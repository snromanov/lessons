package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AbonentCreationTests extends TestBase {


  @Test
  public void contactCreationTests() {
    app.getContactHelper().Home();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData()
            .withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(new ContactData().withName("Терьентий").withSecondname("Терьентьтев").withTelnumber("89500000000").withMail("ma@mail.ru").withGroup("test0"));

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}