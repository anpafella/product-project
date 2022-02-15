package com.product.service;

import java.util.List;

import com.product.model.dto.ProductDTO;

public interface ProductService {

	ProductDTO create(ProductDTO product);

	ProductDTO update(ProductDTO product, Integer id);

	void deleteById(Integer id);

	ProductDTO getById(Integer id);

	List<ProductDTO> getAll();
}
