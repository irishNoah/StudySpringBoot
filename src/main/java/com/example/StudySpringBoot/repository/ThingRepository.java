package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudySpringBoot.entity.Thing;

public interface ThingRepository extends JpaRepository<Thing, Long> {
    // 공통적으로 사용할 수 있는 메소드가 여기 포함될 수 있습니다.
}
