
        package ru.stqa.pft.addressbook.tests;

        import org.testng.annotations.Test;
        import ru.stqa.pft.addressbook.model.ContactData;

        import static org.hamcrest.CoreMatchers.equalTo;

public class testContactPhones extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().gotoHome();
    ContactData contact = app.contact().all().iterator().next(); // загружаем множество контактов
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);//выбираем какой-то контакт случайным образом

    //assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }}
