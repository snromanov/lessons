package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper() {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData", GroupData.class).list();
    for (GroupData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated= '0000-00-00'", ContactData.class).list();
    for (ContactData contact : result) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
  public List<GroupData> groupsWithContacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    String sql = "select distinct gl.* from address_in_groups aig join group_list gl on aig.group_id = gl.group_id ";
    List<GroupData> result = session.createNativeQuery(sql, GroupData.class).list();
    for (GroupData id : result) {
      System.out.println(id);
    }
    session.getTransaction().commit();
    session.close();
    return  result;
  }



  public ContactData loadContactById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    ContactData contactData = session.byId(ContactData.class).load(id);

    session.getTransaction().commit();
    session.close();

    return contactData;
  }
}

