package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
  @Query("SELECT bc.name FROM BookCategory AS bc JOIN Book AS b ON b.id = bc.id")
  List<String> findBookCategory();

  List<Book> findBookByCategory(String category, Pageable pageable);
}
