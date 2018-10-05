package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {




  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
   try
           (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
     String xml ="";
     String line = reader.readLine();
     while (line != null) {
       xml +=line;
       line = reader.readLine();
     }
     XStream xstream = new XStream();
     xstream.processAnnotations(GroupData.class);
     List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
     return  contacts.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator();
   }
  }


  @DataProvider
  public Iterator<Object[]> validContactsXml() throws IOException {
   try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) { String xml = "";
     String line = reader.readLine();
     while (line != null) {
       xml += line;
       line = reader.readLine();
     }
     XStream xstream = new XStream();
     xstream.processAnnotations(ContactData.class);
     List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
     return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();}

  }

  @Test(dataProvider = "validContactsXml")
  public void testContactCreation(ContactData contact) {
    app.goTo().contactListPage();
    Contacts before = app.db().contacts();
    app.goTo().createContactPage();
    app.contact().create(contact);
    app.goTo().contactListPage();
    Contacts after = app.db().contacts();
    Assert.assertEquals(app.group().count(), before.size() + 1);
    app.goTo().contactListPage();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
    verifyContactListInUI();

  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File ("src/test/resources/123.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
    verifyContactListInUI();
  }
}