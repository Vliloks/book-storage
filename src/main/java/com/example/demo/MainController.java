package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.ResponseByAuthor;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MainController {

    private BooksService booksService;

    @Autowired
    public MainController(BooksService booksService) {
        this.booksService = booksService;
    }


//    Загрузка всех книг в формате JSON
    @PostMapping("/post-books")
    public void addBooks(@RequestBody List<Book> allBooks) {
        booksService.saveBooks(allBooks);
    }

//    Получаем все имеющиеся книги
    @GetMapping("/get-all-books")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

//    Получаем количество книг по каждой букве алфавита “А” : 2, “Б”: 5 …
    @GetMapping("/get-count-by-first-letters")
    public HashMap<String, Integer> getCountByFirstLetters() {
        return booksService.getAllByFirstLetter();
    }

//    Получаем список книг отфильтрованные по автору
    @GetMapping("/get-filtered-by-author")
    public List<ResponseByAuthor> getFilteredByAuthor() {
        return booksService.getFilteredByAuthor();
    }

//    Получаем список книг по, заданным пользователем, первым буквам названия /get-by-user-letters?search=...
    @GetMapping("/get-by-user-letters")
    public List<Book> getByUserLetters(@RequestParam(name="search") String search){
        return booksService.getBooksByUserLetters(search);
    }

}
