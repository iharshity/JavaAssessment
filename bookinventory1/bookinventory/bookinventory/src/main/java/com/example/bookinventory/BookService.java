package com.example.bookinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setAvailable(updatedBook.isAvailable());

        bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrGenreContainingIgnoreCase(
            keyword, keyword, keyword
        );
    }
}