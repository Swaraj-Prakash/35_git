package com.javaexp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexp.entity.Category;
import com.javaexp.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/category")
@Slf4j
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public void addCategory(@RequestBody Category category) {
		log.info("CategoryService :: addCategory {}",category.getName());
		categoryService.addCategory(category);
		log.info("Category added successfully");
	}
	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable("id") Long categoryId) {
		
		return categoryService.getCategoryById(categoryId);
	}
	public void UpdateCategory(@PathVariable Long id,@RequestBody Category category) {
		categoryService.update(id,category);
	}
}
