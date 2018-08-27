package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AbonentDeletionTests extends TestBase {



  @Test
  public void ContactDeletionTests() {


    app.getContactHelper().Home();
    app.getContactHelper().selectcontact();
    app.getContactHelper().deletecontact();
    app.getContactHelper().closeAlertWindow();
    app.getContactHelper().Home();

  }
}


