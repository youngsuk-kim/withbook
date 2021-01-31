package com.youngsuk.justbook.book;

import java.util.List;
import lombok.Getter;

@Getter
public class BookPagingDto {
  List<Book> book;
  Integer totalPage;

  public BookPagingDto() {}

  public BookPagingDto(List<Book> book, Integer totalPage) {
    this.book = book;
    this.totalPage = totalPage;
  }
}
