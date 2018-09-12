package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePrecondition() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withHeader("test0"));
    }
  }


  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().list(); //группа до изменения
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withHeader("Новое").withBody("test3").withFooter("test4");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list(); //группа до изменения
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);

  }


}
