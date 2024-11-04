package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudySpringBoot.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Movie 엔티티와 관련된 커스텀 메소드를 여기에 추가할 수 있습니다.
}
