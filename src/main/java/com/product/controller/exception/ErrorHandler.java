package com.product.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.controller.exception.custom.NegativePriceException;
import com.product.controller.exception.custom.PriceOutOfRangeException;
import com.product.controller.exception.custom.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ErrorHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ExceptionHandler({ PriceOutOfRangeException.class })
	protected ResponseEntity<ErrorDitailed> priceOutOfRangeException(final RuntimeException ex) {

		ErrorDitailed errorDitailed = new ErrorDitailed();
		errorDitailed.setErrorCode(ErrorCodeEnum.PRICE_OUT_OF_RANGE.getCode());
		errorDitailed.setErrorMessage(ErrorCodeEnum.PRICE_OUT_OF_RANGE.getMessage());

		return new ResponseEntity<>(errorDitailed, ErrorCodeEnum.PRICE_OUT_OF_RANGE.getHttpstatus());
	}

	@ExceptionHandler({ ProductNotFoundException.class })
	protected ResponseEntity<ErrorDitailed> productNotFoundException(final RuntimeException ex) {

		ErrorDitailed errorDitailed = new ErrorDitailed();
		errorDitailed.setErrorCode(ErrorCodeEnum.PRODUCT_NOT_FOUND.getCode());
		errorDitailed.setErrorMessage(ErrorCodeEnum.PRODUCT_NOT_FOUND.getMessage());

		return new ResponseEntity<>(errorDitailed, ErrorCodeEnum.PRODUCT_NOT_FOUND.getHttpstatus());
	}
	
	@ExceptionHandler({ NegativePriceException.class })
	protected ResponseEntity<ErrorDitailed> NegativePriceException(final RuntimeException ex) {

		ErrorDitailed errorDitailed = new ErrorDitailed();
		errorDitailed.setErrorCode(ErrorCodeEnum.NEGATIVE_PRICE.getCode());
		errorDitailed.setErrorMessage(ErrorCodeEnum.NEGATIVE_PRICE.getMessage());

		return new ResponseEntity<>(errorDitailed, ErrorCodeEnum.NEGATIVE_PRICE.getHttpstatus());
	}

}
