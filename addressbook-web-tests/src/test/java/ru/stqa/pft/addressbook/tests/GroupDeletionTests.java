package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withHeader("test0"));
    }
  }


  @Test
  public void testGroupDeletionTests() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);

    Assert.assertEquals(before, after);
  }


}