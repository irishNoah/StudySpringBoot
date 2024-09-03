package com.example.StudySpringBoot.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudySpringBoot.entity.Team;
import com.example.StudySpringBoot.repository.TeamRepository;

import jakarta.transaction.*;

@Service
public class TeamService {
	@Autowired
    private TeamRepository teamRepository;

    @Transactional
    public Team findTeamById(Long id) {
    	Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    	
    	Hibernate.initialize(team.getPlayers()); // 명시적 초기화
        return team;
    }
}
