package com.youngsuk.justbook.Book;

import java.util.Arrays;

public enum BookCategoryEnum {
  인문("1"),
  참고서("2"),
  IT("3"),
  자기계발("4"),
  심리("5"),
  역사("6"),
  경제("7"),
  소설("8"),
  기타("9");

  private String id;

  BookCategoryEnum(String id) {
    this.id = id;
  }

  public static BookCategoryEnum fromId(String id) {
    return Arrays.stream(values())
        .filter(ca -> ca.id.equalsIgnoreCase(id))
        .findFirst()
        .orElse(null);
  }
}
