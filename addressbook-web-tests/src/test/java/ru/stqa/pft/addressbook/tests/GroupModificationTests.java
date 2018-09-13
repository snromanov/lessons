package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePrecondition() {
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withHeader("test0"));
    }
  }


  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all(); //группа до изменения
    GroupData modifiGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiGroup.getId()).withHeader("Новое").withBody("test3").withFooter("test4");
    app.group().modify(group);
    Set<GroupData> after = app.group().all(); //группа до изменения
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiGroup);
    before.add(group);
    Assert.assertEquals(before, after);

  }


}
