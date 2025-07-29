package com.BookStoreApplication.repository;

import com.BookStoreApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}