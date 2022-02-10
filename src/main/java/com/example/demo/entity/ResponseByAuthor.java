package com.example.demo.entity;

public class ResponseByAuthor {
    private String author;
    private String bookName;

    public ResponseByAuthor(String author, String bookName) {
        this.author = author;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
