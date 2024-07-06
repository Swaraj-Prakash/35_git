package com.javaexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//DSL Methods
	User findByUserName(String username);	
	User findByEmail(String email);
	User findByUserNameAndPassword(String username,String password);	
	User findByUserNameOrEmail(String username,String email);
}
