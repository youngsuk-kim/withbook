package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("/book")
public class BookController {

  private BookRepository bookRepository;
  private BookService bookService;

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  @Autowired
  public void setBookService(BookService bookService) {
    this.bookService = bookService;
  }

  @Cacheable(value = "allCategory")
  @GetMapping("/category")
  public List<String> getAllCategory() {
    return bookRepository.findBookCategory();
  }

  @Cacheable(value = "sortRating")
  @GetMapping("/category/rating")
  public BookPagingDto getPage(@RequestParam Integer page) {
    //평점 순서대로 책 데이터를 가져올때 페이징을 통해 데이터를 전달하기 위해 page를 넘겨주었다.
    return bookService.bookSortByRating(page);
  }

  @Cacheable(value = "bookCategory")
  @GetMapping("/category/{id}")
  public List<Book> getBookByCategory(@PathVariable String id, Pageable pageable) {
    BookCategoryEnum categoryName = BookCategoryEnum.fromId(id);
    return bookRepository.findBookByCategory(categoryName.name(), pageable);
  }
}
