package ru.stqa.pft.addressbook;

public class GroupData {
  private final String header;
  private final String body;
  private final String footer;

  public GroupData(String header, String body, String footer) {
    this.header = header;
    this.body = body;
    this.footer = footer;
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
}
