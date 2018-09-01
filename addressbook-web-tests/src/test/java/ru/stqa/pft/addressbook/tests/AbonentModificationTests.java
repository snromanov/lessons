package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AbonentModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {
    app.getContactHelper().Home();
    app.getContactHelper().selectcontact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().changeFamily();
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();

  }
}
