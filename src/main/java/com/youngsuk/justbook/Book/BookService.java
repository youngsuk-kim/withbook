package com.youngsuk.justbook.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private BookRepository bookRepository;

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public BookPagingDto bookSortByRating(Integer page) {
    Page<Book> books =
        bookRepository.findAll(PageRequest.of(page, 12, Sort.by(Direction.DESC, "rating")));

    return new BookPagingDto(books.getContent(), books.getTotalPages());
  }
}
