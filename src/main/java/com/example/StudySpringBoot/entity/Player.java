package com.example.StudySpringBoot.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Pattern;


@Entity
public class Player {
	@Id
	private String playerId;
	private String Name;
	private String phoneNum;
	private String email;
	private String address;
	
	@Column(length = 8)
    @Pattern(regexp = "\\d{8}", message = "Birthday must be in YYYYMMDD format and contain only numbers.")
	private String birthday;
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	// playerId를 자동으로 생성하기 위한 메서드
    @PrePersist
    public void generatePlayerId() {
        if (this.playerId == null || this.playerId.isEmpty()) {
            this.playerId = generateUniquePlayerId();
        }
    }

    // playerId 생성 로직
    private String generateUniquePlayerId() {
        String prefix = "play";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String randomNumbers = String.format("%04d", new Random().nextInt(10000));
        char randomChar = (char) ('a' + new Random().nextInt(26));

        return prefix + timestamp + randomNumbers + randomChar;
    }
}