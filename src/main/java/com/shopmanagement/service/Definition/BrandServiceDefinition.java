package com.shopmanagement.service.Definition;

import com.shopmanagement.dto.request.BrandRequest;
import com.shopmanagement.dto.response.BrandResponse;
import com.shopmanagement.entity.AttachmentEntity;
import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BrandServiceDefinition {



    void addBrand(BrandRequest brandRequest,MultipartFile file) throws IOException;

    BrandEntity dtoToEntity(BrandRequest brandRequest,MultipartFile file) throws IOException;
    AttachmentEntity uploadImage(MultipartFile file) throws IOException;

    List<BrandResponse> getAllBrand();

   // List<BrandEntity> getBrandByCategory(CategoryEntity catId);

    BrandResponse entityToDto(BrandEntity brandEntity);

    List<BrandResponse> getBrandByCategory(String categoryName);


}
