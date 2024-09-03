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
    	// 모든 Book 객체를 반환
        return bookService.findAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    	// ID로 Book 객체를 조회하여 반환
        Book book = bookService.findBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book) {
    	// 새로운 Book 객체를 생성하여 저장 (영속성 컨텍스트에 추가)
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    	// 기존의 Book 객체를 ID로 조회한 후 업데이트
    	Book book = bookService.findBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            Book updatedBook = bookService.updateBook(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    	// ID로 Book 객체를 조회한 후 삭제
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    
}