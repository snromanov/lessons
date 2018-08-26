package ru.stqa.pft.addressbook.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {



  @Test
  public void testGroupDeletionTests() {
    gotoGroupPage();
    groupHelper.selectGroup();
    groupHelper.deleteGroup();
    groupHelper.returnToGroupPage();
  }

  @AfterMethod
  public void tearDown() {
    groupHelper.wd.quit();
  }


}