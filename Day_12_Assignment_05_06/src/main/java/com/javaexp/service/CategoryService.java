package com.javaexp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaexp.entity.Category;
import com.javaexp.exception.ResourceNotFoundException;
import com.javaexp.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	

	public Category addCategory(Category category) {
		log.info("CategoryService :: addCategory {}",category.getName());
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}
	public Category getCategoryById(Long id) {
		log.info("CategoryService :: categoryById {}",id);
		return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		
	}
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		log.info("Category deleted successfully!..");
	}

	public void update(Long id,Category category) {
		log.info("CategoryService :: update {}",category.getName());
		Category dbCategory= getCategoryById(id);
		dbCategory.setId(category.getId());
		dbCategory.setName(category.getName());
		categoryRepository.save(dbCategory);
		
		log.info("Category update Successfully");
	}
}
