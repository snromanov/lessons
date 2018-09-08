package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AbonentModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {
    app.getContactHelper().Home();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru", "test2"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectcontact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Пупкин", "Василий", "89500000001", "next@mail.ru", null), false);
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }
}
