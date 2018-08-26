package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AbonentDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deletecontact();
    app.getContactHelper().returnConcactPage();
  }


}

