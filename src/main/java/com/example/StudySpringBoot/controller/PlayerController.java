package com.example.StudySpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.StudySpringBoot.entity.Player;
import com.example.StudySpringBoot.repository.PlayerRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @PostConstruct
    public void init() {
    	logger.info("PlayerController - playerRepository is injected with Proxy: " +
                (playerRepository.getClass().getName().contains("$$") || 
                 playerRepository.getClass().getName().startsWith("jdk.proxy")));
        System.out.println("PlayerController - playerRepository is injected with Proxy: " +
                (playerRepository.getClass().getName().contains("$$") || 
                        playerRepository.getClass().getName().startsWith("jdk.proxy")));
        logger.info("PlayerController - Actual class of playerRepository: " + 
                playerRepository.getClass().getName());
        System.out.println("PlayerController - Actual class of playerRepository: " + 
                playerRepository.getClass().getName());
    }
    
    private void logProxyInfo() { 
        boolean isProxy = playerRepository.getClass().getName().contains("$$") || 
                          playerRepository.getClass().getName().startsWith("jdk.proxy");

        logger.info("PlayerController - playerRepository is a Proxy: " + isProxy);
        System.out.println("PlayerController - playerRepository is a Proxy: " + isProxy);

        logger.info("PlayerController - Actual class of playerRepository: " + 
                    playerRepository.getClass().getName());
        System.out.println("PlayerController - Actual class of playerRepository: " + 
                    playerRepository.getClass().getName());
    }
    
    @GetMapping
    public List<Player> getPlayers(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("GET request Player from IP: " + clientIp);
        logProxyInfo();  // 프록시 여부 로그 기록
        return playerRepository.findAll();
    }

    @PostMapping
    public Player addPlayers(@Valid @RequestBody Player players, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("POST request Player from IP: " + clientIp + ", with data: " + players.toString());
        logProxyInfo();  // 프록시 여부 로그 기록
        return playerRepository.save(players);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String playerId, @Valid @RequestBody Player playerDetails, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("PUT request Player from IP: " + clientIp + ", to update Player with ID: " + playerId + ", with data: " + playerDetails.toString());
        logProxyInfo();  // 프록시 여부 로그 기록
        
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setName(playerDetails.getName());
            player.setPhoneNum(playerDetails.getPhoneNum());
            player.setEmail(playerDetails.getEmail());
            player.setAddress(playerDetails.getAddress());
            player.setBirthday(playerDetails.getBirthday());
            
            Player updatedPlayer = playerRepository.save(player);
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Player> deletePlayer(@PathVariable String playerId, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("DELETE request Player from IP: " + clientIp + ", to delete Player with ID: " + playerId);
        logProxyInfo();  // 프록시 여부 로그 기록
        
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            playerRepository.delete(optionalPlayer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}