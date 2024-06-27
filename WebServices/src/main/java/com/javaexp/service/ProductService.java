package com.javaexp.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexp.entity.Product;
import com.javaexp.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(Product product) {
		product.setIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
		log.info("Product save successfully");

	}

	public Product fetchProductInfo(Long productId) {
		log.info("Product fetchById");
		return productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
		
	}

	public Product updateProduct(Long productId,Product product) {
		Product pd=fetchProductInfo(productId);
		pd.setName(product.getName());
		pd.setPrice(product.getPrice());
		pd.setDescription(product.getDescription());
		pd.setQuantity(product.getQuantity());
		log.info("ProductService :: updateProduct {}",product.getName());
		log.info("product successfully updated");
		return productRepository.save(pd);
	}
	public void deleteProduct(Long productId) {
		 productRepository.deleteById(productId);
	}

}
