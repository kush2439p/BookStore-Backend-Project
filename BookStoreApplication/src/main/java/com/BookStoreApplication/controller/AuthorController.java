package com.BookStoreApplication.controller;

import com.BookStoreApplication.entity.Author;
import com.BookStoreApplication.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }
}
