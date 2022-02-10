package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "authors")
    private String authors;

    @Column(name = "article")
    private String article;


    public Book() {
    }

    public Book(Long id, String name, String authors, String article) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
