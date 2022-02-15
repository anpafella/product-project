package com.product.controller.exception.custom;

public class PriceOutOfRangeException extends RuntimeException {

	public PriceOutOfRangeException() {

	}

	public PriceOutOfRangeException(String errorMessage) {
		super(errorMessage);
	}

}


