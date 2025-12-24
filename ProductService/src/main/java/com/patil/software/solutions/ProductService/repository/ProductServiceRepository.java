package com.patil.software.solutions.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patil.software.solutions.ProductService.entity.Product;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, Long>{

}
