package com.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.controller.exception.custom.NegativePriceException;
import com.product.controller.exception.custom.PriceOutOfRangeException;
import com.product.controller.exception.custom.ProductNotFoundException;
import com.product.model.dto.ProductDTO;
import com.product.model.entity.Category;
import com.product.model.entity.Product;
import com.product.model.repository.CategoryRepository;
import com.product.model.repository.ProductRepository;
import com.product.service.ProductService;
import com.product.service.mapper.ProductMapper;

import lombok.SneakyThrows;

@Service
public class ProductServiceImpl implements ProductService {

	// LOGICA Y VALIDACIONES DE NEGOCIO

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductMapper productMapper;

	private final Integer MINIMUM_VALUE = 1;
	private final Integer MAX_VALUE = 100;
	private final Integer NEGATIVE_PRICE = 0;

	@SneakyThrows
	@Override
	public ProductDTO create(ProductDTO productDTO) {

		ProductDTO productDTOtoReturn = new ProductDTO();
//		productDTOtoReturn.setCategoryId(1);

//		ProductDTO productDTOtoReturn2 = ProductDTO.builder().categoryId(1).build();

		if (productDTO.getPrecio() < NEGATIVE_PRICE) {
			throw new NegativePriceException();
		}

		if (productDTO.getPrecio() > MINIMUM_VALUE && productDTO.getPrecio() < MAX_VALUE) {

			Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());

			if (category.isPresent()) {
				Product product = productMapper.toProduct(productDTO);
				product.setCategory(category.get());

				Product newProduct = productRepository.save(product);
				productDTOtoReturn = productMapper.toProductDTO(newProduct);
			}

		} else {
//			System.out.println("El precio debe ser entre 1 y 100 soles");
//			throw new Exception("El precio debe ser entre 1 y 100 soles");
			throw new PriceOutOfRangeException();
		}

		return productDTOtoReturn;
	}

	@SneakyThrows
	@Override
	public ProductDTO update(ProductDTO productDTO, Integer id) {

		if (productDTO.getPrecio() < NEGATIVE_PRICE) {
			throw new NegativePriceException();
		}

		Optional<Product> productoEncontrado = productRepository.findById(id);

		Product productoAactualizar = null;

		if (productoEncontrado.isPresent()) {
			productoAactualizar = productoEncontrado.get();

			productoAactualizar.setStatus(productDTO.getStatus());
			productoAactualizar.setDescription(productDTO.getDescription());
			productoAactualizar.setName(productDTO.getName());
			productoAactualizar.setPrecio(productDTO.getPrecio());

			productRepository.save(productoAactualizar); // update
		} else {
			throw new ProductNotFoundException();
		}

		ProductDTO productoAretornar = productMapper.toProductDTO(productoAactualizar);

		return productoAretornar;
	}

	@Override
	public void deleteById(Integer id) {

		Product productoEncontrado = productRepository.findById(id).get();
		productRepository.delete(productoEncontrado);
		// TODO Auto-generated method stub
	}

	@Override
	public ProductDTO getById(Integer id) {
		Product productoEncontrado = productRepository.findById(id).get();
		ProductDTO productoAretornar = productMapper.toProductDTO(productoEncontrado);

		return productoAretornar;
	}

	@Override
	public List<ProductDTO> getAll() {
		List<Product> allProducts = (List<Product>) productRepository.findAll();
		List<ProductDTO> listaDeDTO = productMapper.toProductDTOlist(allProducts);

		return listaDeDTO;
	}

}
