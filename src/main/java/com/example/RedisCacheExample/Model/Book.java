package com.example.RedisCacheExample.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_author")
    private String bookAuthor;
    @Column(name = "book_description")
    private String bookDescription;
    @Column(name = "book_page")
    private int bookPage;

    public Book(int id, String bookName, String bookAuthor, String bookDescription, int bookPage) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookPage = bookPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }
}
