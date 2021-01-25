package com.youngsuk.justbook.Book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

  @Query(
      value = "SELECT bc.name FROM book_category AS bc JOIN book AS b ON b.id = bc.id",
      nativeQuery = true)
  List<String> findBookCategory();
}
