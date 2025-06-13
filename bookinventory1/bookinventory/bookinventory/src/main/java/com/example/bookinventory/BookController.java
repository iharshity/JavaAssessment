package com.example.bookinventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/book/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "edit";
    }

    @PostMapping("/book")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/book/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/books/search")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        List<Book> results = bookService.searchBooks(keyword);
        model.addAttribute("books", results);
        return "books";
    }
}