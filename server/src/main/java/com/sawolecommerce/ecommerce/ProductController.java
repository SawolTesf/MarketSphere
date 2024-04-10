/* This is going to be our controller class. The controller class is responsible for handling incoming HTTP requests and sending responses back to the client. It is the entry point of the application. */

package com.sawolecommerce.ecommerce;

import org.springframework.web.bind.annotation.RestController;

import com.sawolecommerce.ecommerce.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sawolecommerce.ecommerce.model.Product;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // This tells Spring that this class is a controller
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService){
    this.productService = productService;
  }

  /* Methods */


  // Get products

  @GetMapping("/all") // Returns all product
  public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> products = productService.findAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/find/{id}") // Only returns one product based on id
  public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){ // id in quotes will be the same id passed in GetMapping param
   Product products = productService.findProductById(id);
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  // add products

  @PostMapping("/add")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product newProduct = productService.addProduct(product);
    return new ResponseEntity<>(newProduct, HttpStatus.OK);

  }

  // update products
  @PutMapping("/update") // Since we are updating, we are using PutMapping instead of PostMapping
  public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    Product updatedProduct = productService.addProduct(product);
    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

  }

  // Delete products
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
    productService.deleteProduct(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
