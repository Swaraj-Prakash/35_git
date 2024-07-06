package com.javaexp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaexp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	//JPQL
	@Query("select p from Product p INNER JOIN p.category c where c.name=:categoryName")
	List<Product>fetchProductByCategoryName(String categoryName);
	//DSL
	List<Product>findByCategoryName(String name);

	@Query("select p from Product p where p.barCode=:barCode")
	Product fetchProductUsingJPQL(String barCode);
	
	//native
	@Query(value="select * from product p where p.bar_code=:barCode",nativeQuery = true)
	Product feachProductUsingNative(String barCode);

	Product findByBarCode(String barCode);
	
}
