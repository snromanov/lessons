package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactListPage();
    if (app.db().contacts().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("testFirstName")
              .withLastName("testLastName")
              .withMiddleName("testMiddleName")
              .withAddress("testAddressString")
              .withMiddleName("79991001010")
              .withEmail1("tests@tests.ru")
              .withYear("1999")
              .withGroup("test1"));
    }
  }

  @Test
  public void testContractDeletion(){
    app.goTo().contactListPage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().contactListPage();
    Assert.assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}



