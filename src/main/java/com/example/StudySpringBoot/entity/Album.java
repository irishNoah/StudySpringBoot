package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "ALBUM_ID")
public class Album extends Thing {
	private String artist;
	private String etc;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
