package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// wildcard query (String based search)
	@Query("select p from Product p where p.name like %?1% or p.brand like %?1% or p.made like %?1% or p.phone like %?1%")
	public List<Product> searchProduct(String search);	
	
	// Sorting and Pagination 
	@Query("select p from Product p where p.name like %?1%")
	List<Product> sortByName(String name);		
			
}
