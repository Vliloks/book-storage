package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BooksRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByNameStartingWith(String search);

}
