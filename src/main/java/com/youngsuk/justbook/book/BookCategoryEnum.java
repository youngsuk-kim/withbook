package com.youngsuk.justbook.book;

import java.util.Arrays;

public enum BookCategoryEnum {
  IT("3"),
  경제("7"),
  기타("9"),
  소설("8"),
  심리("5"),
  역사("6"),
  인문("1"),
  자기계발("4"),
  참고서("2");

  private final String id;

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
