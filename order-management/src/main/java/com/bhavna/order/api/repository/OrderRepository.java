package com.bhavna.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.order.api.model.Order;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Modifying
	@Query(value = "DELETE orders from  orders o inner join product p on o.prodId = p.prodId inner join category c on c.category=p.category  WHERE c.category=:category", nativeQuery = true)
	public void deleteByCategory(@Param("category") String category);

	@Query(value = "select * from orders o inner join product p on o.prodId = p.prodId inner join category c on c.category=p.category  WHERE c.category=:category", nativeQuery = true)
	public List<Order> getOrderByCategory(String category);

	@Query(value = "select price from  product  WHERE prodId=:prodId", nativeQuery = true)
	public int getProdPrice(@Param("prodId") int prodId);
	
		
}
