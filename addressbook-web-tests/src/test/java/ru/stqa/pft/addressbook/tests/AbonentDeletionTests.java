package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AbonentDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.getContactHelper().Home();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru", "test2"), true);
    }
    app.getContactHelper().selectcontact(before -1);
    app.getContactHelper().deletecontact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().gotoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);


  }
}


