package com.youngsuk.justbook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngsuk.justbook.book.BookCategory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "BOOK")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "CATEGORY")
  private String category;

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  @JsonIgnore
  private BookCategory bookCategory;

  @Column(name = "AUTHOR")
  private String author;

  @Column(name = "RATING")
  private float rating;

  @Column(name = "PRICE")
  private int price;

  @Column(name = "STOCK_QUANTITY")
  private int stockQuantity;

  @Column(name = "IMG_URL")
  private String imgUrl;
}
