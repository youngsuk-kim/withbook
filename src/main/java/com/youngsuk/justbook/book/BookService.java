package com.youngsuk.justbook.book;

import com.youngsuk.justbook.domain.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

  private BookRepository bookRepository;

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Cacheable(value = "sortRating")
  public BookPagingDto getBookSortByRating(Integer page) {
    Page<Book> books =
        bookRepository.findAll(PageRequest.of(page, 12, Sort.by(Direction.DESC, "rating")));

    return new BookPagingDto(books.getContent(), books.getTotalPages());
  }

  @Cacheable(value = "bookCategory")
  public List<Book> getBookByCategory(String id, Pageable pageable) {
    BookCategoryEnum category = BookCategoryEnum.fromId(id);
    return bookRepository.findBookByCategory(category.name(), pageable);
  }

  @Cacheable(value = "allCategory")
  public List<String> getAllCategoryName() {
    return bookRepository.findBookCategory();
  }

  public List<Book> search(@RequestBody String keyword, Pageable pageable) {
    return bookRepository.findBooksByKeyword(keyword, pageable);
  }
}
