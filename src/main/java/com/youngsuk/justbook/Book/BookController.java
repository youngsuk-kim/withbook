package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {

  private BookRepository bookRepository;

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping("/category")
  public List<String> getAllCategory() {
    return bookRepository.findBookCategory();
  }

  @GetMapping("/category/rating")
  public Iterable<Book> getBookSortByRating() {
    return bookRepository.findAll(PageRequest.of(0, 10, Sort.by(Direction.DESC, "rating")));
  }

  @GetMapping("/category/{id}")
  public Page<Book> getBookByCategory(@PathVariable String id, Pageable pageable) {
    BookCategoryEnum categoryName = BookCategoryEnum.fromId(id);
    return bookRepository.findBookByCategory(categoryName.name(), pageable);
  }
}
