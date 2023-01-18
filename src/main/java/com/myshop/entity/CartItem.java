package com.myshop.entity;


import javax.persistence.*;

import com.myshop.constant.ItemSellStatus;

import lombok.*;


@Entity
@Table(name="cart_item") //테이블 명 설정
@Getter
@Setter
@ToString
public class CartItem {
	
	@Id
	@Column(name="cart_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	private int count;
}
