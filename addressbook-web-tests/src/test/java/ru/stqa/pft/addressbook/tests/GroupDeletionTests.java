package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();// возращает объект типа groups
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.group().all();
    assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));

  }


}