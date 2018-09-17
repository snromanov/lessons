package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().Home();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"), true);
    }
    Set<ContactData> before = app.getContactHelper().all();
    ContactData deletedContact = before.iterator().next();
    int index= before.size() - 1;
    app.getContactHelper().delete(deletedContact);
    Set<ContactData> after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), index);

    before.remove(deletedContact);

    Assert.assertEquals(before, after);
  }
}



