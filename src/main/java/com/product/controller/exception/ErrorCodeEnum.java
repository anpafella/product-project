package com.product.controller.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {

	PRICE_OUT_OF_RANGE("001","Precio debe estar en el rango de 1 y 100", HttpStatus.BAD_REQUEST),
	NEGATIVE_PRICE("002","Precio no puede ser negativo", HttpStatus.BAD_REQUEST),
	PRODUCT_NOT_FOUND("003", "Producto no está en la base de datos", HttpStatus.NOT_FOUND);

	
	
	private String code;
	private String message;
	private HttpStatus httpstatus;
	
	private ErrorCodeEnum(String code, String message, HttpStatus httpstatus) {
		this.code = code;
		this.message= message;
		this.httpstatus= httpstatus;		
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	
	
}
