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
    	System.out.println("saveBook - 객체 영속화!!");
    	em.persist(book);
    	// 트랜잭션이 종료될 때까지 실제로 데이터베이스에 쓰기 작업이 지연됩니다.
    	System.out.println("Book is in persistent context but not yet committed (Lazy Write)");
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
    	Book mergedBook = em.merge(book);
        System.out.println("Book is updated in persistent context but not yet committed (Lazy Write)");
        return mergedBook;
    }

    @Transactional
    public void deleteBook(Long id) {
    	System.out.println("find - 객체 영속화");
    	Book book = em.find(Book.class, id);
        if (book != null) {
        	System.out.println("remove - 객체 삭제");
            em.remove(book);
            System.out.println("Book is removed from persistent context but not yet committed (Lazy Write)");
        }
    }

}
