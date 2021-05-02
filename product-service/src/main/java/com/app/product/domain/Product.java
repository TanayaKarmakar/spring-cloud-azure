package com.app.product.domain;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private String description;
    private List<String> productCategories;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<String> productCategories) {
        this.productCategories = productCategories;
    }

    //    public List<ProductCategory> getProductCategories() {
//        return productCategories;
//    }
//
//    public void setProductCategories(List<ProductCategory> productCategories) {
//        this.productCategories = productCategories;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
