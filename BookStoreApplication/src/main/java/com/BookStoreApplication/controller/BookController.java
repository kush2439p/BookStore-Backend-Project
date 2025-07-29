package com.BookStoreApplication.controller;

import com.BookStoreApplication.entity.Book;
import com.BookStoreApplication.repository.BookRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public Page<Book> getBooks(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size,
                               @RequestParam(defaultValue = "id") String sortBy) {
        return bookRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepo.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setPrice(updatedBook.getPrice());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepo.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
    }
}