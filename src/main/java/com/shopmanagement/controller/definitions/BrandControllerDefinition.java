package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.BrandRequest;
import com.shopmanagement.dto.response.BrandResponse;
import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/brand")
@CrossOrigin("*")
public interface BrandControllerDefinition {

    @RequestMapping("/add-brand")
    void addBrand(@RequestParam("brand") String brandRequest,
                  @RequestParam("image") MultipartFile file) throws IOException;
    @RequestMapping("/get-all")
    List<BrandResponse> getAllBrandName();


    @RequestMapping("/get-brand-by-category/{categoryName}")
    List<BrandResponse> getBrandByCategory(@PathVariable("categoryName") String categoryName);
  /*  @RequestMapping("/get-category-brand/{catId}")
    List<BrandEntity> getBrandByCategoryId(@PathVariable("catId") Long catId);*/


}
