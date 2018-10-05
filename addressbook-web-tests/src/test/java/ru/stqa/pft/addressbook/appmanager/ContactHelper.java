package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  private void checkAndFillGroupInContactForm(ContactData contactData, boolean creation) {
    if (creation){
      Assert.assertTrue(contactData.getGroups().size() == 1);
      new Select(wd.findElement(By.name("new_group")))
              .selectByVisibleText(contactData.getGroups().iterator().next().getHeader());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void fillContactDataForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
  }


  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact(int k) {
    wd.findElements(By.name("selected[]")).get(k).click();
  }

  public int selectContactToGroup() {
    WebElement group = wd.findElements(By.xpath("//select[@name = 'to_group']/option")).iterator().next();
    group.click();
    return  Integer.parseInt(group.getAttribute("value"));
  }

  public void selectGroup(int id) {
    wd.findElement(By.xpath("//select[@name = 'group']/option[@value ='"+id+"']")).click();
  }

  public void addContactToGroup() {
    wd.findElement(By.xpath("//input[@name = 'add']")).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.xpath("//*[@value='"+id+"']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value = 'Delete']"));
  }

  public void deleteContactFromGroup(ContactData contact) {
    selectContactById(contact.getId());
    click(By.name("remove"));
  }

  public void selectDeletedGroupFromList(GroupData group){
    new Select(wd.findElement(By.xpath("//select[@name = 'group']"))).selectByVisibleText(group.getName());

  }
  public void acceptDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void editContact(int id) {
    wd.findElement(By.xpath("//a[@href ='edit.php?id="+id+"'] ")).click();
  }

  public void detailsContact(int id) {
    wd.findElement(By.xpath("//a[@href ='view.php?id="+id+"'] ")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void removeFromGroup() {
    wd.findElement(By.xpath("//input[@name = 'remove']")).click();
  }

  public void createWithGroup(ContactData contactData) {
    fillContactDataForm(contactData);
    checkAndFillGroupInContactForm(contactData, true);
    submitContactCreation();
    contactCache = null;
  }
  public void createWithoutGroup(ContactData contactData) {
    fillContactDataForm(contactData);
    submitContactCreation();
    contactCache = null;
  }


  public void modify(int id, ContactData contact) {
    editContact(id);
    fillContactDataForm(contact);
    checkAndFillGroupInContactForm(contact, false);
    submitContactModification();
    contactCache = null;
  }
  public void delete(ContactData contast) {
    selectContactById(contast.getId());
    deleteSelectedContact();
    contactCache = null;
    acceptDeleteContact();
  }

  private Contacts contactCache =null;


  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    Contacts contactCache = new Contacts();
    WebElement table = wd.findElement(By.id("maintable"));
    List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement row : allRows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String[] allPhones = cells.get(5).getText().split("\n");
      String[] allEmails = cells.get(4).getText().split("\n");

      ContactData contact = new ContactData()
              .withId(id)
              .withLastName(cells.get(1).getText())
              .withFirstName(cells.get(2).getText())
              .withAddress(cells.get(3).getText())
              .withAllEmails(cells.get(4).getText())
              .withAllPhone(cells.get(5).getText());
      if (allPhones.length > 0) {
        contact.withHomePhone(allPhones[0]);
      }
      if (allPhones.length > 1) {
        contact.withMobilePhone(allPhones[1]);
      }
      if (allPhones.length > 2) {
        contact.withWorkPhone(allPhones[2]);
      }
      if (allEmails.length > 0) {
        contact.withEmail1(allEmails[0]);
      }
      if (allEmails.length > 1) {
        contact.withEmail2(allEmails[1]);
      }
      if (allEmails.length > 2) {
        contact.withEmail3(allEmails[2]);
      }
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }


  public int count() {
    return wd.findElements(By.xpath("//tr[@name = 'entry']")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    editContact(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstname)
            .withLastName(lastname)
            .withMiddleName(middlename)
            .withAddress(address)
            .withEmail1(email)
            .withEmail2(email2)
            .withEmail3(email3)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work);
  }
  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }
  public String infoFromDetailsForm(ContactData contact) {
    detailsContact(contact.getId());
    String fullInfo = wd.findElement(By.xpath("//div[@id = 'content']")).getText();
    wd.navigate().back();
    return  fullInfo;
  }


}
