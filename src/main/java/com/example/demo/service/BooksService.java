package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.ResponseByAuthor;

import java.util.HashMap;
import java.util.List;


public interface BooksService {

    void saveBooks(List<Book> allBooks);
    List<Book> getAllBooks();
    HashMap<String, Integer> getAllByFirstLetter();
    List<ResponseByAuthor> getFilteredByAuthor();
    List<Book> getBooksByUserLetters(String search);
}
