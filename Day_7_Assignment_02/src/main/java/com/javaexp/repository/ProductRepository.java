package com.javaexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
