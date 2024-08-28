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
    	// Book 객체를 영속성 컨텍스트에 저장 (영속 상태)
    	em.persist(book);
        return book;
    }

    public Book findBookById(Long id) {
    	// ID로 Book 객체를 데이터베이스에서 조회 (영속 상태)
        return em.find(Book.class, id);
    }

    public List<Book> findAllBooks() {
    	// 모든 Book 객체를 조회
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Transactional
    public Book updateBook(Book book) {
    	// Book 객체를 업데이트 (영속 상태로 전환)
    	return em.merge(book);
    }

    @Transactional
    public void deleteBook(Long id) {
    	// ID로 Book 객체를 조회한 후 삭제 (삭제 상태로 전환)
    	Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }

}
