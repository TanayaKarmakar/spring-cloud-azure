package com.app.product.repository.impl;

import com.app.product.domain.ProductCategory;
import com.app.product.repository.CategoryRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Profile("dev")
public class DevCategoryRepository implements CategoryRepository {
    @Override
    public ProductCategory createCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public Collection<ProductCategory> getAll() {
        return null;
    }

    @Override
    public ProductCategory getById(String uuid) {
        return null;
    }

    @Override
    public ProductCategory updateCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public void deleteCategory(String uuid) {

    }
}
