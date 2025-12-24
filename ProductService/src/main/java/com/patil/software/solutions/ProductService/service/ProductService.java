package com.patil.software.solutions.ProductService.service;

import com.patil.software.solutions.ProductService.model.ProductRequest;
import com.patil.software.solutions.ProductService.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceProductQuantity(long productId, long quantity);

}
