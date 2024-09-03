package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudySpringBoot.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
