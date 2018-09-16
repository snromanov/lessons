package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AbonentDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().Home();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectcontact(before.size() - 1);
    app.getContactHelper().deletecontact();
    app.getContactHelper().closeAlertWindow();
    app.goTo().gotoHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

    Assert.assertEquals(before, after);
  }
}



