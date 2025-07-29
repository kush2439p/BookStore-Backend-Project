package com.BookStoreApplication.repository;

import com.BookStoreApplication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
