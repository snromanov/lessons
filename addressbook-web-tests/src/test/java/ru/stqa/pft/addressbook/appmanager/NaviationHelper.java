package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NaviationHelper extends HelperBase{
 private  FirefoxDriver wd;

  public NaviationHelper(FirefoxDriver wd) {
this.wd = wd;
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
