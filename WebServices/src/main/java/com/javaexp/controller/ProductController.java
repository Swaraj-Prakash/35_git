package com.javaexp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexp.entity.Product;
import com.javaexp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		log.info("ProductController :: createProduct {}",product.getName());
		log.info("product created successfully");
	}
	@GetMapping("{pId}")
	public Product fetchProduct(@PathVariable(name="pId") Long productId) {
		return productService.fetchProductInfo(productId);
		
	}
	@PutMapping("{pId}")
	public Product updateProduct(@PathVariable(name="pId") Long productId,@RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}
	@DeleteMapping("{pid}")
	public void deleteProduct(@PathVariable(name = "pId") Long productId) { 
		productService.deleteProduct(productId);
		log.info("Delete Product Successfully");
	}
}
