package com.example.bookinventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookinventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookinventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner loadDummyBooks(BookRepository bookRepository) {
        return args -> {
            if (bookRepository.count() == 0) {
                bookRepository.save(new Book("Clean Code", "Robert C. Martin", "Programming", true));
                bookRepository.save(new Book("Atomic Habits", "James Clear", "Self-help", true));
                bookRepository.save(new Book("The Alchemist", "Paulo Coelho", "Fiction", false));
            }
        };
    }
}
