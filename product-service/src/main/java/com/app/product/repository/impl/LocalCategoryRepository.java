package com.app.product.repository.impl;

import com.app.product.domain.ProductCategory;
import com.app.product.repository.CategoryRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Profile("local")
public class LocalCategoryRepository implements CategoryRepository {
    private Map<String, ProductCategory> categories = new HashMap<>();

    public ProductCategory createCategory(ProductCategory productCategory) {
        String uuid = UUID.randomUUID().toString();
        productCategory.setUuid(uuid);
        categories.put(uuid, productCategory);
        return productCategory;
    }

    public Collection<ProductCategory> getAll() {
        return categories.values();
    }

    @Override
    public ProductCategory getById(String uuid) {
        return categories.getOrDefault(uuid, new ProductCategory());
    }

    @Override
    public ProductCategory updateCategory(ProductCategory productCategory) {
        String uuid = productCategory.getUuid();
        categories.put(uuid, productCategory);
        return productCategory;
    }

    @Override
    public void deleteCategory(String uuid) {
        categories.remove(uuid);
    }
}
