package com.example.StudySpringBoot.entity;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;

/*
	PDF의 테이블 설계를 보면 ORDER이 아닌 ORDERS로 테이블명이 지어져 있음을 볼 수 있다.
	왜냐하면 "ORDER"는 DB에서 사용되는 SQL 키워드 중 한 가지이기 때문이다.
	어떤 DB에서는 "ORDER" 자체를 테이블명으로 사용되도 문제 없지만,
	특정 DB에서는 문제가 될 수 있으므로, 이런 문제를 미리 대응하고자
	Order 클래스에 대해 @Table(name = "ORDERS") 로 처리하는 게 좋다.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID") // 테이블 설계 참고
	private Long id;
	
	@ManyToOne @JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	@OneToOne @JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	private LocalDateTime orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Delivery getDelivery() {
		return delivery;
	}


	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	public Order() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
