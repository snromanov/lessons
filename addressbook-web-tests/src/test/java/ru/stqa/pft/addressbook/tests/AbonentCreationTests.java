package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class AbonentCreationTests extends TestBase {



  @Test
  public void contactCreationTests() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru","test2"),true);
    app.getContactHelper().returnConcactPage();
  }


}