package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIE")
@DiscriminatorValue("M")
@PrimaryKeyJoinColumn(name = "MOVIE_ID")
public class Movie extends Thing {
	
	@Column(name = "DIRECTOR")
	private String director;
	@Column(name = "ACTOR")
	private String actor;

	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
