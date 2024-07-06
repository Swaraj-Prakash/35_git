package com.javaexp.responses;

import java.util.List;

import com.javaexp.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductBoResponse {

	int totalPageNumbers;
	long totalNumberOfElements;
	List<Product>products;
	
}
