package com.myshop.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.myshop.constant.ItemSellStatus;

import lombok.*;


@Entity
@Table(name="item") //테이블 명 설정
@Getter
@Setter
@ToString
public class Item {
	//not null이 아닐때는 반드시 필드 타입을 객체 (예: int - Integer)로 지정해야한다
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //상품코드
	
	@Column(nullable = false, length = 50)
	private String itemNm; //상품명
	
	@Column(nullable = false, name = "price")
	private int price; //가격
	
	@Column(nullable = false)
	private int stockNumber; //재고수량
	
	@Lob
	@Column(nullable = false)
	private String itemDetail; //상품 상세설명
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus; //상품 판매상태
	
	private LocalDateTime regTime; // 등록시간
	
	private LocalDateTime updateTime; //수정 시간
	
}
