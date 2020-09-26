package com.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engine.model.Product;

public interface ProductRepository extends JpaRepository <Product, String> {

}
