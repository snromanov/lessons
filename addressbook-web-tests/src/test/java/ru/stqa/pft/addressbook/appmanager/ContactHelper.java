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


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname).withSecondname(lastname).
            withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  private void initContactModificationById(int id) {
    //метод  последовательных приближений
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id))); //находим чекбокс
      WebElement row = checkbox.findElement(By.xpath("./../..")); // поиск относительно чекбокс относительно текущего элемента
      List<WebElement> cells = row.findElements(By.tagName("td"));// берём всю строку и ищем ячейку  td
      cells.get(7).findElement(By.tagName("a")).click();// кликаем на карандаш

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click(); //  ищем  с помощью xpath чекбокс и относительно него поднимаемся на два уровня вверх + ищем 8 ячейку(внутри ищем ссылку)
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();


    // до 5.8 wd.findElement(By.cssSelector("input[value='" + id + "']")).findElement(By.xpath("./../../td[8]/a/img")).click();
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


    public int count() {
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
