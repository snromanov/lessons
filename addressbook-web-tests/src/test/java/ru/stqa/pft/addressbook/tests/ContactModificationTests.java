package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {



  public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      if (app.db().contacts().size() == 0){
        Groups groups = app.db().groups();
        app.goTo().createContactPage();
        app.contact().createWithGroup(new ContactData().withFirstName("testFirstName")
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
    public void testContactModification() {
      app.goTo().contactListPage();
      Contacts before = app.db().contacts();
      ContactData modifiedcontact = before.iterator().next();

      ContactData contact =
              new ContactData()
                      .withId(modifiedcontact.getId())
                      .withFirstName("testEditFirstName1")
                      .withLastName("testEditLastName11")
                      .withAddress("address123")
                      .withMiddleName("Name")
                      .withMobilePhone("78900007676")
                      .withEmail1("Edit@Edit.ru")
                      .withYear("1999");
      app.contact().modify(modifiedcontact.getId(), contact);
      app.goTo().contactListPage();
      Assert.assertEquals(app.contact().count(), before.size());
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.without(modifiedcontact).withAdded(contact)));
      verifyContactListInUI();

    }



  }
  }