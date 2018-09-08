package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String name;
  private final String secondname;
  private final String telnumber;
  private final String mail;
  private String group;

  public ContactData(String name, String secondname, String telnumber, String mail, String group) {
    this.name = name;
    this.secondname = secondname;
    this.telnumber = telnumber;
    this.mail = mail;
    this.group = group;
  }

  public String getName() {
    return name;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", secondname='" + secondname + '\'' +
            '}';



  }
}
