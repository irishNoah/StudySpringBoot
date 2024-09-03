package com.example.StudySpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.StudySpringBoot.entity.Thing;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class StudySpringBootApplication implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }

    @Override
    @Transactional // Spring이 트랜잭션을 관리하도록 설정
    public void run(String... args) throws Exception {
    	/* 
		EntityManager를 직접 사용하여 트랜잭션을 관리하는 대신, @Transactional 어노테이션을 사용하여 트랜잭션을 관리해야 합니다. 
		그러나 EntityManager를 이용한 트랜잭션 시작 시도는 제거해야 합니다.
    	 */
        // em.getTransaction().begin();

        // find() 사용
        Thing thingFind = em.find(Thing.class, 1L);
        System.out.println("find()로 조회한 cook: " + thingFind.getName());

        // getReference() 사용
        Thing thingReference = em.getReference(Thing.class, 2L);
        System.out.println("getReference()로 조회한 cook: " + thingReference.getClass().getName()); // Proxy 객체 확인

        // 프록시 객체에 접근
        System.out.println("프록시 객체 접근하여 name 조회: " + thingReference.getName()); // 이 시점에서 DB 쿼리 실행

        
        /* 
		EntityManager를 직접 사용하여 트랜잭션을 관리하는 대신, @Transactional 어노테이션을 사용하여 트랜잭션을 관리해야 합니다. 
		Spring이 자동으로 트랜잭션을 관리하므로, 명시적으로 커밋할 필요가 없습니다.
    	 */
        // em.getTransaction().commit();
    }
}
