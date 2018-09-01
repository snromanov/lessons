package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AbonentModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {
    app.getContactHelper().Home();
    app.getContactHelper().selectcontact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru",null));
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();

  }
}
