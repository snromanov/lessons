package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.tests.TestBase;

public class AbonentCreationTests extends TestBase {



  @Test
  public void contactCreationTests() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru"));
    app.returnConcactPage();
  }


}