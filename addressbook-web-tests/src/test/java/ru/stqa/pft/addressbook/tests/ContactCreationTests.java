package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().contactListPage();
    Contacts before = app.contact().all();
    app.goTo().createContactPage();
    ContactData contact  =  new ContactData()
            .withFirstName("testNewFirstName")
            .withLastName("testNewLastName")
            .withMiddleName("79991088888")
            .withEmail1("New@New.ru")
            .withYear("1888")
            .withGroup("test0");
    app.contact().create(contact);
    app.goTo().contactListPage();
    Contacts after = app.contact().all();
    Assert.assertEquals(app.group().count(), before.size()+1);
    app.goTo().contactListPage();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }
}