package com.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.controller.exception.custom.ProductNotFoundException;
import com.product.model.dto.CategoryDTO;
import com.product.model.entity.Category;
import com.product.model.repository.CategoryRepository;
import com.product.service.CategoryService;
import com.product.service.mapper.CategoryMapper;

import lombok.SneakyThrows;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	CategoryRepository categoryRepository;

	@SneakyThrows
	@Override
	public CategoryDTO create(CategoryDTO categoryDTO) {

		CategoryDTO categoryDTOtoReturn = new CategoryDTO();

		if (!categoryDTO.getDescription().isEmpty() && !categoryDTO.getDescription().isBlank()) {

			Category category = categoryMapper.toCategory(categoryDTO);
			Category newCategory = categoryRepository.save(category);
			categoryDTOtoReturn = categoryMapper.toCategoryDTO(newCategory);
		} else {
			throw new ProductNotFoundException();
		}

		return categoryDTOtoReturn;
	}

}
