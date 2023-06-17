package com.supermarket.demo.Super.Market.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.supermarket.demo.Super.Market.Model.LoginUser;



public interface LoginRepo extends JpaRepository<LoginUser,Long>{

	LoginUser findByEmail(String name);
	
}
