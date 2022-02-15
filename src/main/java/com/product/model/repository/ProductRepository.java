package com.product.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{	
	
}
