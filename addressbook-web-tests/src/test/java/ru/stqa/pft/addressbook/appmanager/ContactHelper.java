package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

public void returnConcactPage(){
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        }

public void deletecontact(){
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        }

public void fillContactForm(ContactData contactData){
  typeone(By.name("firstname"), contactData.getName());
  typeone(By.name("lastname"), contactData.getSecondname());
  typeone(By.name("home"), contactData.getTelnumber());
  typeone(By.name("email"), contactData.getMail());
}

  public void initContactCreation(){
        wd.findElement(By.linkText("add new")).click();
        }

public void selectContact(){
        wd.findElement(By.name("selected[]")).click();
        }
        }
