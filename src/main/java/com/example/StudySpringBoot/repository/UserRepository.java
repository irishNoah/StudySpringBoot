package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudySpringBoot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}