package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AbonentModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {
    app.getContactHelper().Home();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru", "test2"), true);
    }
    app.getContactHelper().selectcontact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Пупкин", "Василий", "89500000001", "next@mail.ru", null), false);
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
