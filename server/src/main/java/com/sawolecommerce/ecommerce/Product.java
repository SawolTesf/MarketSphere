package com.sawolecommerce.ecommerce;

public class Product implements java.io.Serializable{ // Serializable is used to convert the object into a byte stream so that it can be saved to a file, sent over the network, or stored in a database. It is a marker interface, which means it has no methods.
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

    // Overloaded constructor
    public Product(String name, String description, double price, String category, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}