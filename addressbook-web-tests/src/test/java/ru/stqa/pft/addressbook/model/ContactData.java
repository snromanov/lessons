package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final int id;
  private final String name;
  private final String secondname;
  private final String telnumber;
  private final String mail;
  private String group;



  public ContactData(String name, String secondname, String telnumber, String mail, String group) {
    this.id = 0;
    this.name = name;
    this.secondname = secondname;
    this.telnumber = telnumber;
    this.mail = mail;
    this.group = group;
  }


  public ContactData(int id, String name, String secondname, String telnumber, String mail, String group) {
    this.id = id;
    this.name = name;
    this.secondname = secondname;
    this.telnumber = telnumber;
    this.mail = mail;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public String getSecondname() {
    return secondname;
  }

  public String getTelnumber() {
    return telnumber;
  }

  public String getMail() {
    return mail;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", secondname='" + secondname + '\'' +
            '}';
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(secondname, that.secondname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, secondname);
  }

}
