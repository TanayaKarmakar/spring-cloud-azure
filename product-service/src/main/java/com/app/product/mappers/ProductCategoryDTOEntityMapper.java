package com.app.product.mappers;

import com.app.product.domain.ProductCategory;
import com.app.product.dto.ProductCategoryDTO;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryDTOEntityMapper {
    ProductCategoryDTO entityToDTO(ProductCategory productCategory);

    ProductCategory dtoToEntity(ProductCategoryDTO productCategoryDTO);

    Collection<ProductCategoryDTO> listEntityToDTO(Collection<ProductCategory> productCategory);
}
