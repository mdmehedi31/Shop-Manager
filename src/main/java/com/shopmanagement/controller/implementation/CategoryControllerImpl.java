package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.CategoryDefinition;
import com.shopmanagement.dto.request.CategoryRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.service.Definition.CategoryServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControllerImpl implements CategoryDefinition {


    @Autowired
    private CategoryServiceDefinition categoryServiceDefinition;

    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryServiceDefinition.getAllCategory();
    }

  /*  @Override
    public List<String> getAllCategoryName() {
        return categoryServiceDefinition.getAllCategoryName();
    }*/

    @Override
    public void addCategory(CategoryRequest categoryRequest) {

        categoryServiceDefinition.addCategory(categoryRequest);

    }

    @Override
    public CategoryEntity getCategory(Long catId) {
        System.out.println("your category is : "+catId);
        return this.categoryServiceDefinition.getCategoryById(catId);
    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest) {
        categoryServiceDefinition.updateCategory(categoryRequest);
    }

    @Override
    public void deleteCategory(Long catId) {


        System.out.println("from Delete Category Controller.... and your category Id is : "+catId);
        categoryServiceDefinition.deleteCategory(catId);
    }
}
