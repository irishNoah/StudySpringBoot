package com.example.StudySpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.StudySpringBoot.entity.Book;
import com.example.StudySpringBoot.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            Book updatedBook = bookService.updateBook(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    
    // ------------------------------------------------------------------------------------------
    
    @PostMapping("/test-transient")
    public void testtransientStateExample() {
        bookService.transientStateExample();
    }
    
    @PostMapping("/test-persistent")
    public void testpersistentStateExample() {
        bookService.persistentStateExample();
    }
    
    @PostMapping("/test-detached")
    public void testdetachedStateExample() {
        bookService.detachedStateExample();
    }
    
    @PostMapping("/test-transitionToPersistent")
    public void testtransitionToPersistentFromTransient() {
        bookService.transitionToPersistentFromTransient();
    }
    
    @PostMapping("/test-removed")
    public void testremovedStateExample() {
        bookService.removedStateExample();
    }
    
}