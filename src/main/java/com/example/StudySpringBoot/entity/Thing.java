package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "THING")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Thing {
	@Id @Column(name = "ID") @GeneratedValue
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private Integer price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
