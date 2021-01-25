package com.youngsuk.justbook.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class BookCategory {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
