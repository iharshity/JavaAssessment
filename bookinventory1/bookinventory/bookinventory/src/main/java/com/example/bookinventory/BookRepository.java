package com.example.bookinventory;

import com.example.bookinventory.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByAvailable(boolean available);
	List<Book> findByAvailableTrue();
	List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrGenreContainingIgnoreCase(
		    String title, String author, String genre
		);

}
