package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withHeader("test0");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
  /*  Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID); // сортируем старый список
    after.sort(byID); // сортируем новый  список
*/
    Assert.assertEquals(before, after);

  }
}