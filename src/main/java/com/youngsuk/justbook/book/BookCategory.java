package com.youngsuk.justbook.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class BookCategory {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
