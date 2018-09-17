package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().all(); //группа до изменения
    GroupData modifiGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiGroup.getId()).withHeader("Новое").withBody("test3").withFooter("test4");
    app.group().modify(group);

     Groups after = app.group().all(); //группа до изменения
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiGroup).withAdded(group)));
  }
}
