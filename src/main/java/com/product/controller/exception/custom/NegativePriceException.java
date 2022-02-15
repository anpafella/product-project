package com.product.controller.exception.custom;

public class NegativePriceException extends RuntimeException {

	public NegativePriceException() {
	}

	public NegativePriceException(String errorMessage) {
		super(errorMessage);
	}

}
