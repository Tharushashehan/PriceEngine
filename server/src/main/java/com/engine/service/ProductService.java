package com.engine.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.engine.model.Product;

public interface ProductService {
	List<Product> getAll();
	Product create(Product obj);
	Product getById(String id);
	Product update(String id, Product obj);
	Product delete(String id, Product obj);
	ResponseEntity<String> hardDelete(String id);
}
