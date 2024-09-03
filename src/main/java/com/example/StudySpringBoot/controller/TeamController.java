package com.example.StudySpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.StudySpringBoot.entity.Team;
import com.example.StudySpringBoot.service.TeamService;

@RestController
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/team/{id}")
	public Team getTeam(@PathVariable Long id) {
		Team team = teamService.findTeamById(id);
		System.out.println("Team Find : " + team);
		
		// Lazy loading을 확인하기 위해 products 접근 시점에 프록시 객체 확인
		System.out.println("Products in category: " + team.getPlayers());
		
		return team;
	}
}
