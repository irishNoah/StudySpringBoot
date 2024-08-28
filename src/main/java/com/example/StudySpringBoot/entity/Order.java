package com.example.StudySpringBoot.entity;

import java.util.Date;

import jakarta.persistence.*;

/*
	PDF의 테이블 설계를 보면 ORDER이 아닌 ORDERS로 테이블명이 지어져 있음을 볼 수 있다.
	왜냐하면 "ORDER"는 DB에서 사용되는 SQL 키워드 중 한 가지이기 때문이다.
	어떤 DB에서는 "ORDER" 자체를 테이블명으로 사용되도 문제 없지만,
	특정 DB에서는 문제가 될 수 있으므로, 이런 문제를 미리 대응하고자
	Order 클래스에 대해 @Table(name = "ORDERS") 로 처리하는 게 좋다.
 */
@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID") // 테이블 설계 참고
	private Long id;
	
	/*
	    아래와 같이 다른 테이블의 키를 그대로 가져오는 것은 객체 설계를
	    테이블 설계와 맞춘 것이다. 이러한 점은 객체 지향적이지 않다.
	    그렇다면... 객체 지향적으로 짜려면 어떻게 해야 할까?
	
	    // private Member member; 와 같이 짜서, 이 멤버를 통해 값을 가져와야 한다.
	    그 방식은 연관관계 매핑에서 배워보도록 하자!
    */
	@Column(name = "MEMBER_ID") // 테이블 설계 참고
	private Long memberId;
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	public Order() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}
