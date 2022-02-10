package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.ResponseByAuthor;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class BooksServiceImpl implements BooksService{

    private BooksRepository booksRepository;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void saveBooks(List<Book> allBooks) {

        booksRepository.saveAll(allBooks);
    }

    @Override
    public List<Book> getAllBooks() {

        return booksRepository.findAll();
    }

    @Override
    public HashMap<String, Integer> getAllByFirstLetter() {
        HashMap<String, Integer> letterNumberMap = new HashMap<>();

        booksRepository.findAll().stream()
                .sorted((b1, b2)->b1.getName().compareToIgnoreCase(b2.getName()))
                .forEach(book -> {
                    String firstLetter = book.getName().substring(0,1).toUpperCase();
                    if (letterNumberMap.containsKey(firstLetter)){
                        letterNumberMap.put(firstLetter, letterNumberMap.get(firstLetter)+1);
                    } else {
                        letterNumberMap.put(firstLetter, 1);
                    }
                });

        return letterNumberMap;
    }

    @Override
    public List<ResponseByAuthor> getFilteredByAuthor() {
        List<ResponseByAuthor> authorList = new ArrayList<>();
        booksRepository.findAll().stream()
                .sorted((b1, b2)->b1.getAuthors().compareToIgnoreCase(b2.getAuthors()))
                .forEach(book -> authorList.add(new ResponseByAuthor(book.getAuthors(), book.getName())));
        return authorList;
    }

    @Override
    public List<Book> getBooksByUserLetters(String search) {
        return booksRepository.findAllByNameStartingWith(search);
    }
}
