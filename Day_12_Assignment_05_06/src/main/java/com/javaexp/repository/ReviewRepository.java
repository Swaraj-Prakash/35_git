package com.javaexp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	//Optional<Review>findById(Long Id);
	List<Review>findByProductId(Long id);
	
	List<Review>findByProductName(String name);

}
