package ru.stqa.pft.addressbook.model;


import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String firstName;
  private String lastName;
  private String middleName;
  private String address;
  private String homePhone;
  private String allPhones;
  private String mobilePhone;
  private String workPhone;
  private String allEmails;
  private String email;
  private String email2;
  private String email3;
  private String year;
  private String group;
  private File photo;

  public ContactData() {
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withFirstName(String testFirstName) {
    this.firstName = testFirstName;
    return this;
  }

  public ContactData withLastName(String testLastName) {
    this.lastName = testLastName;
    return this;
  }

  public ContactData withMiddleName(String testMiddleName) {
    this.middleName = testMiddleName;
    return this;
  }

  public ContactData withAddress(String testAddressString) {
    this.address = testAddressString;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withEmail1(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email) {
    this.email2 = email;
    return this;
  }

  public ContactData withEmail3(String email) {
    this.email3 = email;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhone(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public int getId() { return id; }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getYear() {
    return year;
  }

  public String getGroup() { return group; }

  public String getAllPhones() {
    return allPhones;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != Integer.MAX_VALUE) {
      if (id != that.id) return false;
    }
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
      return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
}


