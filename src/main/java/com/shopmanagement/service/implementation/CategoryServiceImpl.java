package com.shopmanagement.service.implementation;


import com.shopmanagement.dto.request.CategoryRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.repository.CategoryRepository;
import com.shopmanagement.service.Definition.CategoryServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryServiceDefinition {



    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {

        List<CategoryResponse> getCategoryList= new ArrayList<>();
        List<CategoryEntity> categoryEntityList= categoryRepository.findAll();

        for (CategoryEntity categoryEntity :categoryEntityList) {
            var getCategory= entityToDto(categoryEntity);
            getCategoryList.add(getCategory);
        }

        return getCategoryList;
    }

   /* @Override
    public List<CategoryEntity> getAllCategoryName() {
        return this.categoryRepository.findByCategoryName();
    }*/

    @Override
    public void addCategory(CategoryRequest categoryRequest) {

         categoryRepository.save(dtoToEntity(categoryRequest));

    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest) {

        categoryRepository.save(dtoToEntity(categoryRequest));
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryRequest categoryRequest) {

        CategoryEntity categoryEntity= new CategoryEntity();

        BeanUtils.copyProperties(categoryRequest,categoryEntity);

        categoryEntity.setCategoryName(categoryRequest.getCategoryName());
        categoryEntity.setCategoryDesc(categoryRequest.getCategoryDesc());
        categoryEntity.setAddingDate(categoryRequest.getAddingDate());

        return categoryEntity;
    }

    @Override
    public CategoryResponse entityToDto(CategoryEntity categoryEntity) {

        CategoryResponse categoryResponse= new CategoryResponse();

        BeanUtils.copyProperties(categoryEntity,categoryResponse);


        categoryResponse.setCategoryName(categoryEntity.getCategoryName());
        categoryResponse.setCategoryDesc(categoryEntity.getCategoryDesc());
        categoryResponse.setAddingDate(categoryEntity.getAddingDate());


        return categoryResponse;
    }

    @Override
    public void deleteCategory(Long catId) {

        CategoryEntity categoryEntity= new CategoryEntity();
        categoryEntity.setCatId(catId);
        categoryRepository.delete(categoryEntity);
    }

    @Override
    public CategoryEntity getCategoryById(Long catId) {

        System.out.println("Service class, your category id is : "+catId);
        return this.categoryRepository.findById(catId).get();
    }
}
