package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTest extends TestBase {

  @BeforeMethod


  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test8"));
    }
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().createContactPage();
      app.contact().createWithoutGroup(new ContactData().withFirstName("testFirstName")
              .withLastName("testLastName")
              .withMiddleName("testMiddleName")
              .withAddress("testAddressString")
              .withMiddleName("79991001010")
              .withEmail1("tests@tests.ru")
              .withYear("1999")
              .inGroups(groups.iterator().next()));
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    int groupId = app.db().groupsWithContacts().iterator().next().getId();
    app.goTo().contactListPage();
    app.contact().selectGroup(groupId);
    int contactId = app.contact().all().iterator().next().getId();
    app.contact().selectContactById(contactId);
    app.contact().deleteSelectedContact();

    Groups groups = app.db().loadContactById(contactId).getGroups();
    Optional<Integer> optionalGroupId = groups.stream().map(GroupData::getId).filter((id) -> id == groupId).findFirst();
    assertThat(true, equalTo(optionalGroupId.isPresent()));
  }
}

