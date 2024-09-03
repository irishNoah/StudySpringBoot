package com.example.StudySpringBoot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.StudySpringBoot.entity.Player;
import com.example.StudySpringBoot.entity.Team;
import com.example.StudySpringBoot.repository.PlayerRepository;
import com.example.StudySpringBoot.repository.TeamRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class StudySpringBootApplication implements CommandLineRunner {

	@Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
    	// 초기 데이터 생성
        System.out.println("=== Initializing Data ===");
        Team team = new Team();
        team.setName("Apple FC");

        Player player1 = new Player();
        player1.setName("하하");
        player1.setTeam(team);

        Player player2 = new Player();
        player2.setName("길성준");
        player2.setTeam(team);

        team.setPlayers(Arrays.asList(player1, player2));

        teamRepository.save(team);
        playerRepository.save(player1);
        playerRepository.save(player2);
        System.out.println("=== Data initialization complete ===");
        
        // Team 로드
        System.out.println("=== Fetching Team ===");
        Team loadedTeam = teamRepository.findById(team.getId())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        System.out.println("Category fetched: " + loadedTeam);

        // Lazy Loading 발생 시점 확인
        System.out.println("=== Accessing Players (Lazy Loading) ===");
        System.out.println("Players in Team: " + loadedTeam.getPlayers());

        System.out.println("=== Lazy Loading Complete ===");
    }
}
