package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {

  BookRepository bookRepository;

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping("/category")
  public List<String> getAllCategory() {
    return bookRepository.findBookCategory();
  }
}
