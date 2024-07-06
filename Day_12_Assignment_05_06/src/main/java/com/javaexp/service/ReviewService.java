package com.javaexp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexp.entity.Review;
import com.javaexp.exception.ResourceNotFoundException;
import com.javaexp.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public void addReview(Review review) {
		reviewRepository.save(review);
	}
	public List<Review>getReviewByProductId(Long id){
		return reviewRepository.findByProductId(id);	
	}
	public List<Review>getAllReview(){
		return reviewRepository.findAll();
	}
	public List<Review>getReviewByProductName(String name){
		return reviewRepository.findByProductName(name);
	}
}
