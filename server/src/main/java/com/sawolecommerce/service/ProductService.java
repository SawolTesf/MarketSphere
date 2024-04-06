/* The point of the service layer is to hold the business logic of the application. It calls methods from the repository layer to interact with the database. Here is where you would handle things like transactions and security */
package com.sawolecommerce.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawolecommerce.repo.ProductRepo;
import com.sawolecommerce.model.Product;

import java.util.List;

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

  public List<Product> findAllProducts(){
    return productRepo.findAll(); // This method is used to retrieve all entities from the database
  }

  public Product updateProduct(Product product){
    return productRepo.save(product); // This method is used to update an entity in the database
  }

  public Product findProductById(Long productId){
    return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product by id " + productId + " was not found")); // This method is used to retrieve an entity from the database by its id
  }

  public void deleteProduct(Long productId){
    productRepo.deleteById(productId); // This method is used to delete an entity from the database
  }

}
