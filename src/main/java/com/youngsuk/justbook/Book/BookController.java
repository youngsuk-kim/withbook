package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/category/{id}")
  public List<Book> getBookByCategory(@PathVariable String id) {
    BookCategoryEnum categoryName = BookCategoryEnum.fromId(id);
    return bookRepository.getBookCategoryByCategory(categoryName.name());
  }

}
