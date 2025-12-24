package com.patil.software.solutions.ProductService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductServiceCustomException extends RuntimeException {
	private static final long serialVersionUID = -950437306568833246L;
	private String errorMessageCode;

	public ProductServiceCustomException(String message, String errorMessageCode) {
		super(message);
		this.errorMessageCode = errorMessageCode;
	}
}
