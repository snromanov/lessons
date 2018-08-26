package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.util.concurrent.TimeUnit;

public class TestBase extends ApplicationManager {

  @BeforeMethod
  public void setUp() throws Exception {
    groupHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    groupHelper.wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  @AfterMethod
  public void tearDown() {
    groupHelper.wd.quit();
  }

}