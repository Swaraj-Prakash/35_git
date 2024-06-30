package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entity.Category;
import com.javaexpress.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public void addCategory(@RequestBody Category category) {
		log.info("CategorySer :: addCategory {}",category.getName());
		categoryService.addCategory(category);
		log.info("Category added successfully");
	}
	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable("id") Long categoryId) {
		log.info("CategoryController :: getCategoryById ");
		return categoryService.getCategoryById(categoryId);
	}
	@PutMapping("{id}")
	public void UpdateCategory(@PathVariable Long id,@RequestBody Category category) {
		categoryService.update(id,category);
		log.info("CategoryController :: UpdateCategory {}",category.getName());
	}
	@GetMapping
	public List<Category>allCategory(){
		log.info("AllCategory form categoryController");
		return categoryService.getAllCategory();
		
	}

}
