/* The whole point of the repository layer is to interact with the database (noSql in this case). This will contain methods to create, read, update, and delete records in the database. */

package com.sawolecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawolecommerce.model.Product;
// This interface extends JpaRepository which is a JPA specific extension of Repository. It contains the full API of CrudRepository and PagingAndSortingRepository so that you dont have to write the methods yourself.
public interface ProductRepo extends JpaRepository<Product, Long> {

}
