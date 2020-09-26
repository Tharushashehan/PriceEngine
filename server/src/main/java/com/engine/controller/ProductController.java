package com.engine.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engine.model.Product;
import com.engine.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping("/product-list")
	public List<Product> getAll() {
	    return productServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public Product create(@Valid @RequestBody Product product) {
	    return productServiceImpl.create(product);
	}
	
	@GetMapping("/single-product/{id}")
	public Product getById(@PathVariable(value = "id") String id) {
	    return productServiceImpl.getById(id);
	}
	
	@PutMapping("/put-product/{id}")
	public Product update(@PathVariable(value = "id") String id, @Valid @RequestBody Product product) {
	    return productServiceImpl.update(id, product);
	}
	
	@PutMapping("/delete-product/{id}")
	public Product delete(@PathVariable(value = "id") String id, @Valid @RequestBody Product product) {
	    return productServiceImpl.delete(id, product);
	}
	
	@PostMapping("/purchase")
	public String purchaseCalculator(@Valid @RequestBody List<Product> productLst) {
		double amount = 0.0;
		for(int i=0; i<productLst.size(); i++) {
			amount = amount + ((productLst.get(i).getCarton_price()/productLst.get(i).getCarton_size())*(productLst.get(i).getNo_of_units_purchased()%productLst.get(i).getCarton_size())*productLst.get(i).getCompansation() + (productLst.get(i).getNo_of_units_purchased()/productLst.get(i).getCarton_size())*productLst.get(i).getCarton_price());
		}
	    return "{\"total\" : \""+ amount +"\"}";
	}
}
