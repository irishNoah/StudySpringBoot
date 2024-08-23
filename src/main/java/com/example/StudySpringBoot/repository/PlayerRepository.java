package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudySpringBoot.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
