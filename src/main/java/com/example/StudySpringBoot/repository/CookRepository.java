package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudySpringBoot.entity.Cook;

public interface CookRepository extends JpaRepository<Cook, Long> {
    // Cook 엔티티와 관련된 커스텀 메소드를 여기에 추가할 수 있습니다.
}
