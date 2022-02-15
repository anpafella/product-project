package com.product.service.mapper;

import org.springframework.stereotype.Component;

import com.product.model.dto.CategoryDTO;
import com.product.model.entity.Category;

@Component
public class CategoryMapper {

	public Category toCategory(CategoryDTO categoryDTO) {
		Category category = new Category();

		category.setId(categoryDTO.getId());
		category.setDescription(categoryDTO.getDescription());

		return category;
	}

	public CategoryDTO toCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();

		categoryDTO.setId(category.getId());
		categoryDTO.setDescription(category.getDescription());

		return categoryDTO;

	}

}
