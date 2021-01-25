package com.youngsuk.justbook.Book;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookCategory {
  @Id
  @GeneratedValue
  private Integer id;

  @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
  private List<Book> book = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Book> getBook() {
    return book;
  }

  public void setBook(List<Book> book) {
    this.book = book;
  }
}
