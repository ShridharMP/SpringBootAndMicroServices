package com.patil.software.solutions.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.patil.software.solutions.ProductService.model.ErrorResponse;

@ControllerAdvice
public class ProductServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception) {
		return new ResponseEntity<>(ErrorResponse.builder().errorMessage(exception.getMessage())
				.errorcode(exception.getErrorMessageCode()).build(), HttpStatus.NOT_FOUND);
	}
}
