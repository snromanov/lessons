package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactListPage();
    if (app.db().contacts().size() == 0){
      app.goTo().createContactPage();
      app.contact().createWithoutGroup(new ContactData().withFirstName("testFirstName")
              .withLastName("testLastName")
              .withMiddleName("testMiddleName")
              .withAddress("testAddressString")
              .withMiddleName("79991001010")
              .withEmail1("tests@tests.ru")
              .withYear("1999"));
    }
  }
  @Test
  public void testContactAddress(){
    app.goTo().contactListPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo((contactInfoFromEditForm.getAddress())));
    verifyContactListInUI();
  }
}