package com.javaexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaexp.entity.Product;
import com.javaexp.responses.ProductBoResponse;
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
	@GetMapping
	public List<Product>fetchAllProdct(){
		return productService.fetchAllProduct();
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
	@GetMapping("category/{name}")
	public List<Product> fetchProductByCategoryName(@PathVariable("name") String name) {
		return productService.findByCategoryName(name);
	}
	@GetMapping("/pagination")
	public ProductBoResponse fetchProducts(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "5")Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortBy) {
		
		if(sortBy.equals("ASC")) {
			return productService.fetchProducts(PageRequest.of(pageNo, pageSize,Direction.ASC,"price"));
		}else {	
			return productService.fetchProducts(PageRequest.of(pageNo, pageSize,Direction.DESC,"price"));
		}
		
	}
}
