package com.scaler.ecomproductservice.repository;

import com.scaler.ecomproductservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String title);

    @Query(value = CustomQueries.FIND_PRODUCT_BY_TITLE ,nativeQuery = true)
    Product findProductByTitleLike(String title);

    @Query(value = "select * from Product",nativeQuery = true)
    Product findAllProducts(String title);
}
