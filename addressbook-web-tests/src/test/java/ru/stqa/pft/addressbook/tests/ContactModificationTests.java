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

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"), true);
    }

    Contacts before = app.getContactHelper().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).
            withName("Василий").withSecondname("Пупкин").withTelnumber("89500000001").withMail("next@mail.ru");
    app.getContactHelper().modify(contact);
    assertThat(app.getContactHelper().count(),equalTo(before.size()));
    Contacts after = app.getContactHelper().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
