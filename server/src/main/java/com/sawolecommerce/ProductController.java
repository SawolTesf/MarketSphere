/* This is going to be our controller class. The controller class is responsible for handling incoming HTTP requests and sending responses back to the client. It is the entry point of the application. */

package com.sawolecommerce;

import org.springframework.web.bind.annotation.RestController;

import com.sawolecommerce.ecommerce.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sawolecommerce.ecommerce.model.Product;
import java.util.List;

@RestController // This tells Spring that this class is a controller
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService){
    this.productService = productService;
  }

  // Methods
  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> products = productService.findAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }
  
}
