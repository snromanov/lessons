package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {

    app.getContactHelper().Home();
    ContactData contact = new ContactData().withId()
            .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0");
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(contact, true);
    }

    Contacts before = app.getContactHelper().all();

    ContactData modifiedContact = before.iterator().next();
    app.getContactHelper().modify(modifiedContact);
    app.getContactHelper().fillContactForm(new ContactData().
            withName("Василий").withSecondname("Пупкин").withTelnumber("89500000001").withMail("next@mail.ru"), false);
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();

    Contacts after = app.getContactHelper().all();


    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
