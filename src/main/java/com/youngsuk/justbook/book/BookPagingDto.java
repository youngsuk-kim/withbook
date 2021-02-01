package com.youngsuk.justbook.book;

import java.util.List;
import lombok.Getter;

@Getter
public class BookPagingDto {
  private List<Book> book;
  private Integer totalPage;

  public BookPagingDto() {}

  public BookPagingDto(List<Book> book, Integer totalPage) {
    this.book = book;
    this.totalPage = totalPage;
  }
}
