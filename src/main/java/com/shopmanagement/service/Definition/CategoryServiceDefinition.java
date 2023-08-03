package com.shopmanagement.service.Definition;

import com.shopmanagement.dto.request.CategoryRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.entity.CategoryEntity;

import java.util.List;

public interface CategoryServiceDefinition {


    List<CategoryResponse> getAllCategory();

   // List<CategoryEntity> getAllCategoryName();
    void addCategory(CategoryRequest categoryRequest);

    void updateCategory(CategoryRequest categoryRequest);

    CategoryEntity dtoToEntity(CategoryRequest categoryRequest);

    CategoryResponse entityToDto(CategoryEntity categoryEntity);

    void  deleteCategory(Long catId);

    CategoryEntity getCategoryById(Long catId);

}
