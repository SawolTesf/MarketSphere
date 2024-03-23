package com.sawolecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawolecommerce.model.Product;
public interface ProductRepo extends JpaRepository<Product, String> {

}
