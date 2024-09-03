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
import com.example.StudySpringBoot.service.TeamService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class StudySpringBootApplication implements CommandLineRunner {

	@Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamService teamService;
    
    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
    	// 초기 데이터 생성
        System.out.println("=== Initializing Data ===");
        Team team = new Team();
        team.setName("Chelsea FC");

        Player player1 = new Player();
        player1.setName("Drogba");
        player1.setTeam(team);

        Player player2 = new Player();
        player2.setName("Chech");
        player2.setTeam(team);

        team.setPlayers(Arrays.asList(player1, player2));

        teamRepository.save(team);

        System.out.println("=== Data initialization complete ===");

        // 특정 ID의 팀 삭제 (ID를 적절히 설정)
        Long teamIdToDelete = team.getId();
        teamService.deleteTeamById(teamIdToDelete);

        System.out.println("=== Team and its Players deleted ===");
    }
}
