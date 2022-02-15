package com.product.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.dto.CategoryDTO;
import com.product.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/crear")
	public CategoryDTO crear(@RequestBody @Valid CategoryDTO category) {
		CategoryDTO categoryRecibida = categoryService.create(category);

		return categoryRecibida;
	}

}
