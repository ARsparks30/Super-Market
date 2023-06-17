package com.supermarket.demo.Super.Market.Repo;


import org.springframework.data.jpa.repository.JpaRepository;


import com.supermarket.demo.Super.Market.Model.Supplier;



public interface SupplierRepo extends JpaRepository<Supplier,Long>{
	
	
}
