package com.product.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
