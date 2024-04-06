/* The whole point of the repository layer is to interact with the database (noSql in this case). This will contain methods to create, read, update, and delete records in the database. */

package com.sawolecommerce.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawolecommerce.ecommerce.model.Product;
// This interface extends JpaRepository which is a JPA specific extension of Repository. It contains the full API of CrudRepository and PagingAndSortingRepository so that you dont have to write the methods yourself.
public interface ProductRepo extends JpaRepository<Product, Long> { // The first parameter is the entity type and the second parameter is the type of the primary key of the entity. The primary key of the entity is how we identify the entity in the database in the service and repository layers.

}
