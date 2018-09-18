package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {
  private Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnConcactPage() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void deletecontact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    typeone(By.name("firstname"), contactData.getName());
    typeone(By.name("lastname"), contactData.getSecondname());
    typeone(By.name("home"), contactData.getTelnumber());
    typeone(By.name("email"), contactData.getMail());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
/*
  public void closeAlertWindow() {
    wd.switchTo().alert().accept();
  }


  // click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")); //брать первый  из списка


 /*
  public void selectcontact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }*/

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlert();
    contactCache = null;
    Home();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    verifityUpdate();
    contactCache = null;
    Home();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).findElement(By.xpath("./../../td[8]/a/img")).click();
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void Home() {
    click(By.linkText("home"));
  }

  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void verifityUpdate() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  /*
    public int getContactCount() {
      return wd.findElements(By.name("selected[]")).size(); // вернуть размер  элемента
    }

    /*
    public List<ContactData> getContactList() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
      for (WebElement element : elements) {
        String name = element.findElement(By.xpath(".//td[3]")).getText();
        String lastname = element.findElement(By.xpath(".//td[2]")).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        contacts.add(new ContactData().withId(id).withName(name).withSecondname(lastname));
      }
      return contacts;
    }
  */

  public void createContact(ContactData contactData, boolean b) {
    initContactCreation();
    fillContactForm(contactData, b);
    returnConcactPage();
    contactCache = null;
    Home();
  }

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withSecondname(lastname));
    }
    return new Contacts(contactCache);
  }


}
