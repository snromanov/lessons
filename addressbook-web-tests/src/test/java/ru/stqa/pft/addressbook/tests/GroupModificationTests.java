package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {


  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("TEST1",null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList(); //группа до изменения
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getContactHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Новое", "test3", "test4"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //группа до изменения
    Assert.assertEquals(after.size(), before.size());
  }
}
