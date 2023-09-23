package com.example.RedisCacheExample.Service;

import com.example.RedisCacheExample.Model.Book;
import com.example.RedisCacheExample.RedisCacheExampleApplication;
import com.example.RedisCacheExample.Repo.BookRepo;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepo bookRepo;
    Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public void bookAdd(Book book){
        this.bookRepo.save(book);
    }
    @CacheEvict(cacheNames = "book",allEntries = true)
    public void delete(int bookId){
        logger.info("Deleted " + bookId + "book");
        this.bookRepo.deleteById(bookId);
    }
    @Cacheable(value = "allBooks")
    public List<Book>getAllBook(){
        logger.info("Getting all books from the database");
        return this.bookRepo.findAll();
    }
    @Cacheable(cacheNames = "book", key = "#bookId")
    public Optional<Book> getById(int bookId) {
        logger.info("Getting book with ID: " + bookId);
        return this.bookRepo.findById(bookId);
    }

    @CachePut(cacheNames = "book", key = "#bookId")
    public Book bookUpdate(int bookId, Book book) {
        logger.info("Updating book with ID: " + bookId);
        Optional<Book> bookToUpdate = this.bookRepo.findById(bookId);

        if (bookToUpdate.isPresent()) {
            Book updatedBook = bookToUpdate.get();
            updatedBook.setBookAuthor(book.getBookAuthor());
            updatedBook.setBookName(book.getBookName());
            updatedBook.setBookPage(book.getBookPage());
            return this.bookRepo.save(updatedBook);
        } else {
            // Kitap bulunamazsa veya güncellenemezse bir hata işleyin veya null döndürün.
            return null;
        }
    }

}
