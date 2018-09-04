package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String header;
  private final String body;
  private final String footer;

  public GroupData(String header, String body, String footer) {
    this.header = header;
    this.body = body;
    this.footer = footer;
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "header='" + header + '\'' +
            '}';
  }

  public String getHeader() {
    return header;
  }

  public String getBody() {
    return body;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(header, groupData.header);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header);
  }
}
