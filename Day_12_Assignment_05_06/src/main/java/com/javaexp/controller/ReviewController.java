package com.javaexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaexp.entity.Review;
import com.javaexp.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/review")
@Slf4j
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public void addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		log.info("ReviewController :: addReview {}",review.getProduct());
	}
	@GetMapping("/product/{id}")
	public List<Review>getAllReview(@PathVariable Long id){
		log.info("ReviewController :: getAllReview {}");
		return reviewService.getReviewByProductId(id);
	}
	@GetMapping
	public List<Review>getAllReview(){
		return reviewService.getAllReview();
	}
	@GetMapping("/products")
	public List<Review>getReviewByProductName(@RequestParam String name){
		return reviewService.getReviewByProductName(name);
	}
}
