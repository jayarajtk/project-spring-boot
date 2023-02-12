package com.jay.shop.product.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.jay.shop.product.catalog.repository"})
public class CatalogConfig {
}