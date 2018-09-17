package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().Home();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"), true);
    }
    Contacts before = app.getContactHelper().all();
    ContactData deletedContact = before.iterator().next();
    int index = before.size() - 1;
    app.getContactHelper().delete(deletedContact);
    Contacts after = app.getContactHelper().all();

    assertEquals(after.size(), index);

    assertThat(after, equalTo(before.without(deletedContact)));

  }
}



