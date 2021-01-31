package com.youngsuk.justbook.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private String category;

  @ManyToOne
  @JoinColumn(name = "category_id")
  @JsonIgnore
  private BookCategory bookCategory;

  private String author;

  private float rating;

  private int price;

  private int stockQuantity;

  private String imgUrl;
}
