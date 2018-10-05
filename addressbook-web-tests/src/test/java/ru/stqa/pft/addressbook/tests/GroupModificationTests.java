package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePrecondition() {
if (app.db().groups().size()==0 )
    {app.goTo().GroupPage();
      app.group().create(new GroupData().withHeader("test0"));
    }
  }


  @Test
  public void testGroupModification() {
    Groups before = app.db().groups(); //группа до изменения
    GroupData modifiGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiGroup.getId()).withHeader("Новое").withBody("test3").withFooter("test4");

    app.goTo().GroupPage();
    app.goTo().GroupPage();app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
     Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiGroup).withAdded(group)));
    verifyGroupListInUI();
  }


}
