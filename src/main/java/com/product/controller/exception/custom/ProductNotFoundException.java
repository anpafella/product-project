package com.product.controller.exception.custom;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
