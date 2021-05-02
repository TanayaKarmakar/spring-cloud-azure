package com.app.product.service.impl;

import com.app.product.domain.ProductCategory;
import com.app.product.dto.ProductCategoryDTO;
import com.app.product.mappers.ProductCategoryDTOEntityMapper;
import com.app.product.repository.CategoryRepository;
import com.app.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductCategoryDTOEntityMapper productCategoryDTOEntityMapper;

    @Override
    public ProductCategory createCategory(ProductCategoryDTO productCategoryDTO) {
        return categoryRepository
                .createCategory(productCategoryDTOEntityMapper.dtoToEntity(productCategoryDTO));
    }

    @Override
    public Collection<ProductCategory> getAll() {
       return categoryRepository.getAll();
    }

    @Override
    public ProductCategory getById(String id) {
        return categoryRepository.getById(id);
    }

    @Override
    public ProductCategory updateCategory(ProductCategoryDTO productCategoryDTO) {
        return categoryRepository
                .updateCategory(productCategoryDTOEntityMapper.dtoToEntity(productCategoryDTO));
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteCategory(id);
    }
}
