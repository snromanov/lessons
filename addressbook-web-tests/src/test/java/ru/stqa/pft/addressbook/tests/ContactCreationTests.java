package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().Home();
    ContactData contact = new ContactData()
            .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0");
    Contacts before = app.getContactHelper().all();
    app.getContactHelper().createContact(contact, true);
    assertThat(app.getContactHelper().count(),equalTo(before.size() + 1));
    Contacts after = app.getContactHelper().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}