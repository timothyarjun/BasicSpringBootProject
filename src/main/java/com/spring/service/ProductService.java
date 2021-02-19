package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.entity.Product;
import com.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll(){
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product getOne(Long id) {
		return repo.findById(id).get();
	}
	
	public Product update(Product product) {
		return repo.saveAndFlush(product);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Product> searchProduct(String search){
		return repo.searchProduct(search);
	}
	
	public List<Product> getAllProductSort(Integer pageNo,Integer pageSize,String sortBy){
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(Direction.DESC, sortBy));	
		Page<Product> pageResult=repo.findAll(paging);
		
		if(pageResult.hasContent()) {
			return pageResult.getContent();
		}
		else {
			return new ArrayList<Product>();
		}
	}

	public List<Product> getPage(Integer page, Integer pageSize) {
		Pageable paging=PageRequest.of(page, pageSize);
		Page<Product> pageList=repo.findAll(paging);
		
		if(pageList.hasContent())
			return pageList.getContent();
		else
			return new ArrayList<Product>();
	}	
	
	public List<Product> multiSort(Boolean flag){
		//Sort nameSort=Sort.by("name");
		//Sort priceSort=Sort.by("price");
		
		if(flag) {
			Sort priceSort=Sort.by("price").ascending();
			return repo.findAll(priceSort);
			
//			Sort groupSort=nameSort.and(priceSort).ascending();
//			 List<Product> sortList= repo.findAll(groupSort);
//			 return sortList;
		}
		else {
			Sort priceSort=Sort.by("price").descending();
			return repo.findAll(priceSort);
			
//			Sort groupSort=nameSort.and(priceSort).descending();
//			 List<Product> sortList= repo.findAll(groupSort);
//			 return sortList;
		}
		
	}
		
	
}
