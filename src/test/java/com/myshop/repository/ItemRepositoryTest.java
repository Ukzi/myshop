package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired // 의존성주입
	ItemRepository itemRepository;
	
	@PersistenceContext //영속성 컨텍스트를 사용하기 위해 선언
	EntityManager em; //엔티티 매니저

//	@Test //테스트할 메소드 위에 어노테이션
//	@DisplayName("상품 저장 테스트") //테스트 이름을 지정 어노테이션
//	public void createItemTest() {
//		Item item = new Item();
//		item.setItemNm("테스트 상품");
//		item.setPrice(10000);
//		item.setItemDetail("테스트 상품 상세 설명");
//		item.setItemSellstatus(ItemSellStatus.SELL);
//		item.setStockNumber(100);
//		item.setRegTime(LocalDateTime.now());
//		item.setUqdateTime(LocalDateTime.now());
//		
//		Item savedItem = itemRepository.save(item); //데이터 insert
//		
//		System.out.println(savedItem.toString());
//	}

	public void createItemTest() {
		for (int i = 1; i <= 10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			Item savedItem = itemRepository.save(item); // 데이터 insert
		}
	}
	
	   public void createItemTest2() {
		      for (int i = 1; i <= 5; i++) {
		         Item item = new Item();
		         item.setItemNm("테스트 상품" + i);
		         item.setPrice(10000 + i);
		         item.setItemDetail("테스트 상품 상세 설명" + i);
		         item.setItemSellStatus(ItemSellStatus.SELL);
		         item.setStockNumber(100);
		         item.setRegTime(LocalDateTime.now());
		         item.setUpdateTime(LocalDateTime.now());
		         Item savedItem = itemRepository.save(item); // 데이터 insert
		      }
		      for (int i = 6; i <= 10; i++) {
		         Item item = new Item();
		         item.setItemNm("테스트 상품" + i);
		         item.setPrice(10000 + i);
		         item.setItemDetail("테스트 상품 상세 설명" + i);
		         item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
		         item.setStockNumber(0);
		         item.setRegTime(LocalDateTime.now());
		         item.setUpdateTime(LocalDateTime.now());
		         Item savedItem = itemRepository.save(item); // 데이터 insert
		      }

		   }
	

//	@Test
//	@DisplayName("상품명 조회 테스트")
//	public void findByItemNmTest() {
//		this.createItemTest(); //item 테이블에 insert (for문 이 입력됨)
//		List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//		
//	}
//	
//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByItemNmOrItemDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("가격 LessThan 테스트")
//	public void findByPriceLessThanTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThan(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("가격 내림차순 조회 테스트")
//	public void findByPriceLessThanOrderByPriceDescTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	
//	@Test
//	@DisplayName("1번 문제 테스트")
//	public void findByItemNmAndItemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("2번 문제 테스트")
//	public void findByPriceBetweenTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceBetween(10004, 10008);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("3번 문제 테스트")
//	public void findByRegTimeAfterTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByRegTimeAfter(LocalDateTime.of(2023, 1, 1, 12, 12, 44));
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("4번 문제 테스트")
//	public void findByItemSellStatusNotNullTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemSellStatusNotNull();
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("5번 문제 테스트")
//	public void findByItemDetailEndingWithTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailEndingWith("설명1");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//
//	@Test
//	@DisplayName("@Query를 이용한 상품 조회 테스트")
//	public void findByItemDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//
//	@Test
//	@DisplayName("@Query를 이용한 상품 조회 테스트")
//	public void findByItemDetailByNativeTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//}
//	@Test
//	@DisplayName("문 1")
//	public void findByPriceVativeTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceVative(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("문 2")
//	public void findByItemNmitemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmitemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("querydsl 조회 테스트")
//	public void queryDslTest1() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		//select*from itemSellStatus = 'SELL'
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//								.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//								.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
//								.orderBy(qItem.price.desc());
//		
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("querydsl 조회 테스트 2")
//	public void queryDslTest2() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		Pageable page = PageRequest.of(0, 2); //of(조회할 페이지의 번호, 한페이지당 조회할 데이터의 갯수)
//
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//				.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
//				.where(qItem.price.gt(10003))
//				.offset(page.getOffset())
//				.limit(page.getPageSize());
//
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//		System.out.println(item.toString());
//		}
//	
//	}
//
//	@Test
//	@DisplayName("문제 3-1")
//	public void queryDslTest31() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		//select*from itemSellStatus = 'SELL'
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//								.where(qItem.itemNm.like("%테스트 상품1%"))
//								.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL));
//		
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//
//	@Test
//	@DisplayName("문제 3-2")
//	public void queryDslTest32() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		//select*from itemSellStatus = 'SELL'
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.price.between(10004, 10008));
//		
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("문제 3-3")
//	public void queryDslTest33() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		//select*from itemSellStatus = 'SELL'
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//								.where(qItem.regTime.after(LocalDateTime.of(2023, 1, 1, 12, 12, 44)));
//		
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//
//	
//	@Test
//	@DisplayName("문제 3-4")
//	public void queryDslTest34() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
//		QItem qItem = QItem.item;
//		//select*from itemSellStatus = 'SELL'
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.itemSellStatus.isNotNull());
//		
//		List<Item> itemList = query.fetch();
//		
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//
//	
	@Test
	@DisplayName("문제 3-5")
	public void queryDslTest35() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
		QItem qItem = QItem.item;
		//select*from itemSellStatus = 'SELL'
		JPAQuery<Item> query = qf.selectFrom(qItem)
				.where(qItem.itemDetail.endsWith("설명1"));
		
		List<Item> itemList = query.fetch();
		
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}

	
	}




























