package com.javaexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
