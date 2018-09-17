package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().Home();
    ContactData contact = new ContactData()
            .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0");
    Set<ContactData> before = app.getContactHelper().all();
    app.getContactHelper().createContact(contact, true);
    Set<ContactData> after = app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
    before.add(contact);

   // assertThat(after, equalTo(before.withAdded(contact)));//  ПОМЕНЯТЬ List на set
  }
}