package com.app.product.repository;

import com.app.product.domain.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CategoryRepository {
    ProductCategory createCategory(ProductCategory productCategory);

    Collection<ProductCategory> getAll();

    ProductCategory getById(String uuid);

    ProductCategory updateCategory(ProductCategory productCategory);

    void deleteCategory(String uuid);

}
