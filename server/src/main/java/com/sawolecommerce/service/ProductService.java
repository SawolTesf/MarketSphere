package com.sawolecommerce.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawolecommerce.repo.ProductRepo;
import com.sawolecommerce.model.Product;

@Service // This tells Spring that this class is a service which in simple terms is a class that contains business logic. Business logic is the part of the program that encodes the real-world business rules that determine how data can be created, stored, and changed.
public class ProductService {
  private final ProductRepo productRepo;

  @Autowired // This annotation allows Spring to resolve and inject collaborating beans into your bean which means that it will automatically create an instance of ProductRepo and inject it into ProductService
  public ProductService(ProductRepo productRepo){
    this.productRepo = productRepo;
  }

  // Methods
  public Product addProduct(Product product){
    return productRepo.save(product); // This method is used to save an entity to the database
  }

}
