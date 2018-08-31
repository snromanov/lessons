package ru.stqa.pft.addressbook.model;

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
}