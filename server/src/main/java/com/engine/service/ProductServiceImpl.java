package com.engine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.engine.exception.ResourceNotFoundException;
import com.engine.model.Product;
import com.engine.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product create(Product obj) {
	    return productRepository.save(obj);
	}

	@Override
	public Product getById(String id) {
	    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public Product update(String id, Product obj) {
		Product dbObject = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		Product updatedNode = productRepository.save(dbObject);
	    return updatedNode;
	}

	@Override
	public Product delete(String id, Product obj) {
		Product dbObject = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	    dbObject.setStatus_code(false);
	    Product deletedNote = productRepository.save(dbObject);
	    return deletedNote;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
