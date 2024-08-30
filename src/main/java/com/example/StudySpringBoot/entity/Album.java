package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ALBUM")
@DiscriminatorValue("A")
@PrimaryKeyJoinColumn(name = "ALBUM_ID")
public class Album extends Thing {
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
