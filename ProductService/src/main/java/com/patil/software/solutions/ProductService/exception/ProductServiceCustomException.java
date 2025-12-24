package com.patil.software.solutions.ProductService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProductServiceCustomException extends RuntimeException {
	private static final long serialVersionUID = -950437306568833246L;
	private String errorCode;

	public ProductServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
