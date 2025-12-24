package com.patil.software.solutions.ProductService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "QUANTITY")
	private long quantity;
}
