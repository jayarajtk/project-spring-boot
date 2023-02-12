package com.jay.shop.product.catalog.service;

import com.jay.shop.product.catalog.constants.ProductCatalog;
import com.jay.shop.product.catalog.entity.Product;
import com.jay.shop.product.catalog.repository.ProductCatalogRepository;
import com.jay.shop.product.catalog.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
    @Autowired
    private Validation validation;

    @Override
    public List<Product> getAllProduct() {
        return productCatalogRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        if (product != null) {
            return productCatalogRepository.save(product);
        }
        return new Product();
    }

    @Override
    public List<Product> searchProduct(Map<String, String> allRequstParam) {
        if (!CollectionUtils.isEmpty(allRequstParam)) {
            for (Entry<String, String> entry : allRequstParam.entrySet()) {
                String param = entry.getKey();
                String val = entry.getValue();
                if (ProductCatalog.PRODUCT_TYPE.equalsIgnoreCase(param) && !StringUtils.isEmpty(val)) {
                    return productCatalogRepository.findByProductType(val);
                }
            }
        }
        return null;
    }

    @Override
    public String deleteProduct(long id) {
        try {
            productCatalogRepository.deleteById(id);
            return ProductCatalog.SUCCESS;
        } catch (Exception exception) {
            return ProductCatalog.FAILED;
        }
    }
}