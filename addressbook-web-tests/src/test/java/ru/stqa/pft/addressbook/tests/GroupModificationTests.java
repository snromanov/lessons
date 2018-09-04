package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {


  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();//количество групп до измения
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("TEST1",null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getContactHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Новое", "test3", "test4"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();//количество групп после измения
    Assert.assertEquals(after, before);
  }
}
