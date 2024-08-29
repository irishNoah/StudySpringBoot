package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERITEM")
public class OrderItem {
	@Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID") // 테이블 설계 참고
    private Long id;
    
	/* 참조를 사용하도록 변경 */
    @ManyToOne @JoinColumn(name = "ORDER_ID")
    private Order order;
    
    /* 참조를 사용하도록 변경 */
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    
    private int orderPrice;
    private int count;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    
    
}
