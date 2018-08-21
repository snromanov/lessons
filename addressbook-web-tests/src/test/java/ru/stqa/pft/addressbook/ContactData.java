package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String secondname;
  private final String telnumber;
  private final String mail;

  public ContactData(String name, String secondname, String telnumber, String mail) {
    this.name = name;
    this.secondname = secondname;
    this.telnumber = telnumber;
    this.mail = mail;
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
}
