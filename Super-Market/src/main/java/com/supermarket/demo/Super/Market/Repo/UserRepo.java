package com.supermarket.demo.Super.Market.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.demo.Super.Market.Model.User;



public interface UserRepo extends JpaRepository<User,Long>{

	
}
