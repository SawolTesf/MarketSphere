package com.sawolecommerce.ecommerce;

// Information on how to use database in spring boot: https://spring.io/guides/gs/accessing-data-mysql

// Importing the necessary libraries
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Product implements java.io.Serializable{ // Serializable is used to convert the object into a byte stream so that it can be saved to a file, sent over the network, or stored in a database. It is a marker interface, which means it has no methods.

    @Id // This tells Hibernate to make a column in the table as the primary key
    @GeneratedValue(strategy=GenerationType.AUTO) // This tells Hibernate to generate the value automatically
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // toString method
    @Override
    public String toString() {
      return "Product{" +
              "name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", price=" + price +
              ", category='" + category + '\'' +
              ", imageUrl='" + imageUrl + '\'' +
              '}';
    }
}