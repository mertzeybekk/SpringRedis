package com.example.RedisCacheExample.Controller;

import com.example.RedisCacheExample.Model.Book;
import com.example.RedisCacheExample.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/bookAdd")
    public void  bookAdd(@RequestBody Book book){
        this.bookService.bookAdd(book);
    }
    @GetMapping("/bookAll")
    public List<Book>getAll(){
        return this.bookService.getAllBook();
    }
    @GetMapping("/bookId/{bookId}")
    public Optional<Book> getBookId(@PathVariable int bookId){
        return this.bookService.getById(bookId);
    }
    @PostMapping("/bookUpdate/{bookId}")
    public Book bookUpdate(@PathVariable int bookId,@RequestBody Book book){
       return this.bookService.bookUpdate(bookId,book);
    }
    @PostMapping("/bookId/{bookId}")
    public void deleteBook(@PathVariable int bookId){
        this.bookService.delete(bookId);
    }

    }
