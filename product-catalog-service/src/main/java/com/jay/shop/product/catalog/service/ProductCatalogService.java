package com.jay.shop.product.catalog.service;

import com.jay.shop.product.catalog.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductCatalogService {
    List<Product> getAllProduct();
    Product addProduct(Product product);
    List<Product> searchProduct(Map<String, String> allRequstParam);
    String deleteProduct(long id);
}