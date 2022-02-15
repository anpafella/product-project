package com.product.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.product.model.dto.ProductDTO;
import com.product.model.entity.Product;

@Component
public class ProductMapper {

	public Product toProduct(ProductDTO productDTO) {
		Product product = new Product();

		product.setId(productDTO.getId());
		product.setDescription(productDTO.getDescription());
		product.setName(productDTO.getName());
		product.setStatus(productDTO.getStatus());
		product.setPrecio(productDTO.getPrecio());

		return product;
	}

	public ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setName(product.getName());
		productDTO.setStatus(product.getStatus());
		productDTO.setPrecio(product.getPrecio());
		productDTO.setCategoryId(product.getCategory().getId());
		return productDTO;

	}

	public List<ProductDTO> toProductDTOlist(List<Product> productList) {
		List<ProductDTO> listaARetornar = new ArrayList<>();

		for (Product product : productList) {
			ProductDTO productDTO = toProductDTO(product);

			listaARetornar.add(productDTO);

		}

		return listaARetornar;
	}

}