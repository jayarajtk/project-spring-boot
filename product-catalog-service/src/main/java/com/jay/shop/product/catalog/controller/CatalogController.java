package com.jay.shop.product.catalog.controller;

import com.jay.shop.product.catalog.entity.Product;
import com.jay.shop.product.catalog.exception.ServiceException;
import com.jay.shop.product.catalog.service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/")
public class CatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    ProductCatalogService productCatalogueService;

    @GetMapping(value = "/product/all")
    @ResponseBody
    public List<Product> getAllProduct() throws Exception {
        return productCatalogueService.getAllProduct();
    }

    @GetMapping(value = "/product")
    @ResponseBody
    public List<Product> searchProduct(@RequestParam Map<String, String> allRequstParam) {
        return productCatalogueService.searchProduct(allRequstParam);
    }

    @PostMapping("/product")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productCatalogueService.addProduct(product);
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") long id) throws ServiceException {
        if (id == 1) {
            throw new ServiceException("ERR_01", "Cannot delete").addDetail("test", "test1");
        }
        return productCatalogueService.deleteProduct(id);
    }
}