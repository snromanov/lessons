package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {


  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("TEST1",null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getContactHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Новое", "test3", "test4"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoHome();
  }
}
