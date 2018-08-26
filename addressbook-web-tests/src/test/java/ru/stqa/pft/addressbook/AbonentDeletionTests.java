package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class AbonentDeletionTests extends TestBase {


  @Test
  public void ContactDeletionTests() {
    app.selectContact();
    app.returnConcactPage();
  }

}

