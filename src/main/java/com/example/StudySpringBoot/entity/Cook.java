package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COOK")
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "COOK_ID")
public class Cook extends Thing {
	@Column(name = "COOKER")
	private String cooker;

	public String getCooker() {
		return cooker;
	}

	public void setCooker(String cooker) {
		this.cooker = cooker;
	}
	
}
