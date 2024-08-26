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
}
