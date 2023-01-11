package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;



//JpaRepasitory : 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의가 되어있다.
//JpaRepasitory<사용할 엔티티 클래스, 기본키 타입>
public interface ItemRepository extends JpaRepository<Item, Long>{
	//select*from item where item_nm = ? 이랑 같은 의미
	List<Item> findByItemNm(String itemNm);
	
	//select*from item where item_nm =? or item_detail = ?
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
	
	//select*from item where price < ?
	List<Item> findByPriceLessThan(Integer price);
	
	//select*from item where price < ? order by price desc
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
	
//	//select*from item where item_nm = ? and itemsellstatus = ?
//	List<Item> findByItemNmAndItemSellStatus(String itemNm, ItemSellStatus SELL);
//	//select*from item where price < ?
//	List<Item> findByPriceBetween(Integer price1, Integer price2);
//	//select*from item where price < ?
//	List<Item> findByRegTimeAfter(LocalDateTime regTime);
//	//select*from item where price < ?
//	List<Item> findByItemSellStatusNotNull();
//	//select*from item where price < ?
//	List<Item> findByItemDetailEndingWith(String itemDetail);
	
//	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
//	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail); 
	
//	@Query("select i from Item i where i.itemDetail like %?1% order by i.price desc")
//	List<Item> findByItemDetail(String itemDetail); 
//	                                                가져온 파라미터 값을 넣어주고 싶은 경우 : 를 붙이고 사용한다
//	@Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
//	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
//	                                                 받은 값을 쿼리에 넣어줘야 할 경우 @Param을 사용한다
//	                                                 받은 파라메터를 @Param(이름)으로 쿼리문에 넣어둔다
//	
//	@Query(value = "select * from item i where i.price >= :price", nativeQuery = true)
//	List<Item> findByPriceVative(Integer price);
	
//	@Query("select i from Item i where i.itemNm in :itemNm and i.itemSellStatus in :itemSellStatus")
//	List<Item> findByItemNmitemSellStatus(@Param("itemNm") String itemNm, @Param("itemSellStatus") ItemSellStatus itemSellStatus);
	
	
}




























