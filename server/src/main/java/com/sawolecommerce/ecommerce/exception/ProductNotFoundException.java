package com.sawolecommerce.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message); // This calls the constructor of the parent class (RuntimeException) and passes the message to it. Shows how we can use polymorphism and inheritance in Java
    }
}