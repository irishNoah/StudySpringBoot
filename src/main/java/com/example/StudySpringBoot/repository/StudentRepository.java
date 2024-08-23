package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudySpringBoot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
}
