package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")

@Entity

@Table(name = "group_list")
public class GroupData {

  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(header, groupData.header) &&
            Objects.equals(body, groupData.body) &&
            Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, header, body, footer);
  }

  @Expose
  @Column(name = "group_name")
  private String header;
  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String body;
  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;


  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withBody(String body) {
    this.body = body;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
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
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", header='" + header + '\'' +
            '}';
  }

  /*
  private  String header;
  private  String body;
  private  String footer;
*/

}
