package ru.stqa.pft.addressbook.model;

import java.util.Objects;


public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String secondname;
  private String telnumber;
  private String mail;
  private String group;



    public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(secondname, that.secondname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, secondname);
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withSecondname(String secondname) {
    this.secondname = secondname;
    return this;
  }

  public ContactData withTelnumber(String telnumber) {
    this.telnumber = telnumber;
    return this;
  }

  public ContactData withMail(String mail) {
    this.mail = mail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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

}
