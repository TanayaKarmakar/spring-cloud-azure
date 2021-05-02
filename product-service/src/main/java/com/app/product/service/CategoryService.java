package com.app.product.service;

import com.app.product.domain.ProductCategory;
import com.app.product.dto.ProductCategoryDTO;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    ProductCategory createCategory(ProductCategoryDTO productCategoryDTO);

    Collection<ProductCategory> getAll();

    ProductCategory getById(String id);

    ProductCategory updateCategory(ProductCategoryDTO productCategoryDTO);

    void deleteCategory(String id);
}
