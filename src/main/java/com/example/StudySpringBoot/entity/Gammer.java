package com.example.StudySpringBoot.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	name = "GammerInfo",
	uniqueConstraints = {
			@UniqueConstraint(columnNames = {"phoneNum"})
	}
)
public class Gammer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="USER_NM", nullable = false, length = 50)
	private String username;
	@Column(name="TEAM_NM", nullable = true, length = 100)
	private String teamname;
	@Column(name="USER_PHN_NUM", nullable = false, length = 15)
	private String userphonenum;
	@Column(name="USER_AGE")
	private Integer userage;
	@Column(name="GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="CRTD_DATE")
	@Temporal(TemporalType.TIMESTAMP) // 날짜타입생성 Date, Time, Timestamp 3가지 타입이 있음
    private Date createdDate;
	@Column(name="DSRC")
	@Lob // DB에 varchar를 넘어서는 문자를 넣고 싶을때, 예를 들면 게시판 contents, 파일 바이너리 등
    private String description;
	
	// JPA 기본적으로 동적으로 객체를 생성하는 기능이 있어, 기본 생성자도 추가해줘야 된다.
    public Gammer() {
    }
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getUserphonenum() {
		return userphonenum;
	}
	public void setUserphonenum(String userphonenum) {
		this.userphonenum = userphonenum;
	}
	public Integer getUserage() {
		return userage;
	}
	public void setUserage(Integer userage) {
		this.userage = userage;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
