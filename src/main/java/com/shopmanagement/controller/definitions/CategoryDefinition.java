package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.CategoryRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.entity.CategoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@CrossOrigin("*")
public interface CategoryDefinition {



    @RequestMapping("/")
    List<CategoryResponse> getAllCategory();

    /*@RequestMapping("/get-category-name")
    List<String> getAllCategoryName();*/
    @RequestMapping("/add-category")
    void addCategory(@RequestBody CategoryRequest categoryRequest);

    @RequestMapping("/get-category/{catId}")
    CategoryEntity getCategory(@PathVariable("catId") Long catId);

    @PutMapping("/update-category")
    void updateCategory(@RequestBody CategoryRequest categoryRequest);
    @DeleteMapping("/delete-category/{catId}")
    void deleteCategory(@PathVariable("catId") Long catId);


}
