package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactListPage();
    if (app.contact().all().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("testFirstName")
              .withLastName("testLastName")
              .withMiddleName("testMiddleName")
              .withAddress("testAddressString")
              .withMiddleName("79991001010")
              .withEmail1("tests@tests.ru")
              .withYear("1999")
              .withGroup("test0"));
    }
  }

  @Test
  public void testContactEmails() {
    app.goTo().contactListPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream().filter((e) -> !e.equals("")).map(ContactEmailTest::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email;
  }
}