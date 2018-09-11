package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AbonentModificationTests extends TestBase {

  @Test
  public void ContactModificationTests() {
    app.getContactHelper().Home();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Терьентий", "Терьентьтев", "89500000000", "ma@mail.ru", "test2"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("Василий", "Пупкин", "89500000001", "next@mail.ru", null), false);
    app.getContactHelper().verifityUpdate();
    app.getContactHelper().Home();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(new ContactData("Василий", "Пупкин", "89500000001", "next@mail.ru", null));

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);


  }
}
