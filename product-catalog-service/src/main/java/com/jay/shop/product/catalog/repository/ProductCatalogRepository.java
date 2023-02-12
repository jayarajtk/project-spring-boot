package com.jay.shop.product.catalog.repository;

import com.jay.shop.product.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductCatalogRepository extends JpaRepository<Product, Long> {

    @Query("select products from Product products where products.productType = :productType")
    List<Product> findByProductType(@Param("productType") String productType);

    /*@Modifying
    @Transactional
    @Query("delete from Product products where products.id = :id ")
    int deleteById(@Param("id") Long id);*/

}
