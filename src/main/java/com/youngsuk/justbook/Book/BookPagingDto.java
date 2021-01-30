package com.youngsuk.justbook.Book;

import java.util.List;

public class BookPagingDto {

  public List<Book> getContent() {
    return content;
  }

  public Integer getTotalPageCount() {
    return totalPageCount;
  }

  List<Book> content;

  Integer totalPageCount;

  public BookPagingDto(List<Book> content, Integer totalPageCount) {
    this.content = content;
    this.totalPageCount = totalPageCount;
  }
}
