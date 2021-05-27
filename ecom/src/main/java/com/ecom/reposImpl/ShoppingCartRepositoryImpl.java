package com.ecom.reposImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.beans.Item;
import com.ecom.entity.ShoppingCart;


@Repository
public interface ShoppingCartRepositoryImpl extends JpaRepository<ShoppingCart, Long>{

	Pageable sortedByName = 
			  PageRequest.of(0, 3, Sort.by("name"));
	ShoppingCart findByCartId(String cartId);
	
	ShoppingCart findItemsListByCartId(String cartId);
	
	List<ShoppingCart> findAllByName(String name, Pageable sortedByName);
	
	@Transactional
	@Modifying
	@Query("Update ShoppingCart d set d.item=?1 where d.cartId=?2")
	void updateCartItems(String item, String cartId);
}
