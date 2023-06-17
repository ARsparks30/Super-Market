package com.supermarket.demo.Super.Market.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.demo.Super.Market.Model.Item;



public interface ItemRepo extends JpaRepository<Item,Long>{
	
	Item findByItemName(String name);
	
}
