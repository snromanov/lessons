
        package ru.stqa.pft.addressbook.tests;

        import org.testng.annotations.Test;
        import ru.stqa.pft.addressbook.model.ContactData;

public class testContactPhones extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().gotoHome();
    ContactData contact = app.contact().all().iterator().next(); // загружаем множество контактов
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);//выбираем какой-то контакт случайным образом

    assertThat(contact.getHomephone(), equalTo(cleaned(contactInfoFromEditForm.getHomephone())));
    assertThat(contact.getMobilephone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFromEditForm.getWorkphone())));
  }
  public static String cleaned(String phone) {

    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
