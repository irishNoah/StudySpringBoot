package com.example.StudySpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudySpringBoot.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Book saveBook(Book book) {
    	em.persist(book);
        return book;
    }

    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    public List<Book> findAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Transactional
    public Book updateBook(Book book) {
    	return em.merge(book);
    }

    @Transactional
    public void deleteBook(Long id) {
    	Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }
    
    // ----------------------------------------------------------------------------
    
    // 영속성 상태를 연습하기 위한 새로운 메서드들
    public void transientStateExample() {
    	// 이 book 객체는 현재 '일시적 상태'에 있습니다.
    	System.out.println("Start - transientStateExample 비영속");
        Book book = new Book();
        book.setTitle("Transient Book");
        book.setAuthor("Author A");
        System.out.println("End - transientStateExample 비영속");
    }

    @Transactional
    public void persistentStateExample() {
    	System.out.println("Start - persistentStateExample 비영속 to 영속");
        Book book = new Book();
        book.setTitle("Persistent Book");
        book.setAuthor("Author B");
        em.persist(book); // 이 book 객체는 이제 '영속 상태'가 됩니다.
        System.out.println("End - persistentStateExample 비영속 to 영속");
    }

    @Transactional
    public void detachedStateExample() {
    	System.out.println("Start - detachedStateExample 영속 to 준영속");
        Book book = new Book();
        book.setTitle("Detached Book");
        book.setAuthor("Author C");
        em.persist(book); // 이 book 객체는 '영속 상태'가 됩니다.
        em.detach(book);  // 이 book 객체는 이제 '준영속 상태'가 됩니다.
        System.out.println("End - detachedStateExample 영속 to 준영속");
    }

    @Transactional
    public void transitionToPersistentFromTransient() {
    	System.out.println("Start - transitionToPersistentFromTransient 준영속 to 영속");
        Book book = new Book();
        book.setTitle("New Persistent Book");
        book.setAuthor("Author D");
        em.persist(book); // 이 book 객체는 '일시적 상태'에서 '영속 상태'로 전환됩니다.
        System.out.println("End - transitionToPersistentFromTransient 준영속 to 영속");
    }

    @Transactional
    public void removedStateExample() {
    	System.out.println("Start - removedStateExample 영속 to 삭제");
        Book book = new Book();
        book.setTitle("Removed Book");
        book.setAuthor("Author E");
        em.persist(book); // 이 book 객체는 '영속 상태'가 됩니다.
        em.remove(book);  // 이 book 객체는 이제 '제거된 상태'가 됩니다.
        System.out.println("End - removedStateExample 영속 to 삭제");
    }

}
