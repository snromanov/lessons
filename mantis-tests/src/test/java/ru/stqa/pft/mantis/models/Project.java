package ru.stqa.pft.mantis.models;


public class Project {
  private int id;
  private String name;

  public String getName() {
    return name;
  }

  public Project setName(String name) {
    this.name = name;
    return this;
  }

  public int getId() {
    return id;
  }

  public Project setId(int id) {
    this.id = id;
    return this;
  }
}