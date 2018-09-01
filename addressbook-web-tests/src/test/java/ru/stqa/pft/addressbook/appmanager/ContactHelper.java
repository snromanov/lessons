package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
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


  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void closeAlertWindow() {
    wd.switchTo().alert().accept();
  }

  public void selectcontact() {
    {
      wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr[3]/td[1]/input")).click();
    }
    ;
  }

  public void Home() {
    click(By.linkText("home"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
  }


  public void verifityUpdate() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contactData, boolean b) {
    fillContactForm(contactData,b);
    Home();
  }
}


