package com.patil.software.solutions.ProductService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patil.software.solutions.ProductService.entity.Product;
import com.patil.software.solutions.ProductService.exception.ProductServiceCustomException;
import com.patil.software.solutions.ProductService.model.ProductRequest;
import com.patil.software.solutions.ProductService.model.ProductResponse;
import com.patil.software.solutions.ProductService.repository.ProductServiceRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductServiceRepository productServiceRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding Product...");
		Product product = Product.builder().productName(productRequest.getProductName())
				.quantity(productRequest.getQuantity()).productId(productRequest.getProductId())
				.price(productRequest.getPrice()).build();

		productServiceRepository.save(product);
		log.info("Product Created..");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productById) {
		log.info("Getting product Details");
		Product product = productServiceRepository.findById(productById)
				.orElseThrow(() -> new ProductServiceCustomException("Product not found for given id:" + productById,
						"PRODUCT_NOT_FOUND"));
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		log.info("Product Details");
		return productResponse;
	}

	@Override
	public void reduceProductQuantity(long productId, long quantity) {
		log.info("Reducing the product quantity {} for id {}", quantity, productId);
		Product product = productServiceRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product not found for given id:" + productId,
						"PRODUCT_NOT_FOUND"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException(
					"Product Quantity" + quantity + "not available for given Product id " + productId,
					"INSUFFICIENT_QUANTITY");
		}
		product.setQuantity(product.getQuantity() - quantity);
		productServiceRepository.save(product);
	}

}
