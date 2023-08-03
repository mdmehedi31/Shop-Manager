package com.shopmanagement.controller.implementation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shopmanagement.controller.definitions.BrandControllerDefinition;
import com.shopmanagement.dto.request.BrandRequest;
import com.shopmanagement.dto.response.BrandResponse;
import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.service.Definition.BrandServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

public class BrandControllerImpl implements BrandControllerDefinition {


    @Autowired
    private BrandServiceDefinition brandServiceDefinition;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void addBrand(String brandRequest, MultipartFile file) throws IOException {

        System.out.println("before mapper " + brandRequest);
        System.out.println("brand ");
       BrandRequest brand  = mapper.readValue(brandRequest, BrandRequest.class);


        System.out.println("brand category is "+brand.getCategoryName());
       // System.out.println("brand name is : "+brand.getBrandName()+", category Id/name is : "+brand.getCatNameId().getCatId());
        brandServiceDefinition.addBrand(brand,file);
    }

    @Override
    public List<BrandResponse> getAllBrandName() {

        return brandServiceDefinition.getAllBrand();
    }

    @Override
    public List<BrandResponse> getBrandByCategory(String categoryName) {
        return brandServiceDefinition.getBrandByCategory(categoryName);
    }

//    @Override
//    public List<BrandEntity> getBrandByCategoryId(Long catId) {
//
//
//        ObjectMapper objectMapper= new ObjectMapper();
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//
//
//        CategoryEntity category= new CategoryEntity();
//        category.setCatId(catId);
//
//
//
//        return brandServiceDefinition.getBrandByCategory(category);
//    }
}
