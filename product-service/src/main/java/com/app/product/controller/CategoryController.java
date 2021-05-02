package com.app.product.controller;

import com.app.product.domain.ProductCategory;
import com.app.product.dto.ProductCategoryDTO;
import com.app.product.mappers.ProductCategoryDTOEntityMapper;
import com.app.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductCategoryDTOEntityMapper productCategoryDTOEntityMapper;

    //create category
    @PostMapping
    public ProductCategoryDTO createCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = categoryService.createCategory(productCategoryDTO);
        return productCategoryDTOEntityMapper.entityToDTO(productCategory);
    }

    //get all category
    @GetMapping
    public Collection<ProductCategoryDTO> getAll() {
        Collection<ProductCategory> productCategories = categoryService.getAll();
        return productCategoryDTOEntityMapper.listEntityToDTO(productCategories);
    }

    //get category by id
    @GetMapping("/{id}")
    public ProductCategoryDTO getCategoryById(@PathVariable("id") String id) {
        return productCategoryDTOEntityMapper.entityToDTO(categoryService.getById(id));
    }

    //update category
    @PutMapping
    public ProductCategoryDTO updateCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        return productCategoryDTOEntityMapper.entityToDTO(categoryService.updateCategory(productCategoryDTO));
    }

    //delete category
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") String id) {
        categoryService.deleteCategory(id);
    }
}
