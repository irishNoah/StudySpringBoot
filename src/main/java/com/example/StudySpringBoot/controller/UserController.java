package com.example.StudySpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.StudySpringBoot.entity.User;
import com.example.StudySpringBoot.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public User addUsers(@RequestBody User users, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		logger.info("POST request from IP: " + clientIp + ", with data: " + users.toString());
        return userRepository.save(users);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("PUT request from IP: " + clientIp + ", to update user with ID: " + id + ", with data: " + userDetails.toString());

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            // 필요한 다른 필드들도 업데이트합니다.
            
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        logger.info("Delete request from IP: " + clientIp + ", to Delete user with ID: " + id);

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
        	userRepository.delete(optionalUser.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping
	public List<User> getUsers(HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
        logger.info("GET request from IP: " + clientIp);
        return userRepository.findAll();
    }
	
}