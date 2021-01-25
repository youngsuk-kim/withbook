package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
  @Query("SELECT bc.name FROM BookCategory AS bc JOIN Book AS b ON b.id = bc.id")
  List<String> findBookCategory();

  List<Book> getBookCategoryByCategory(String category);
}
