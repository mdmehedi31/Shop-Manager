package com.shopmanagement.service.implementation;

import com.shopmanagement.dto.request.BrandRequest;
import com.shopmanagement.dto.response.BrandResponse;
import com.shopmanagement.entity.AttachmentEntity;
import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.repository.AttachmentRepository;
import com.shopmanagement.repository.BrandRepository;
import com.shopmanagement.repository.CategoryRepository;
import com.shopmanagement.service.Definition.BrandServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class BrandServiceImpl implements BrandServiceDefinition {


    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private final String FOLDER_PATH="C:\\my file\\Code\\All java Code\\sahin enterpries images\\";
    @Override
    public void addBrand(BrandRequest brandRequest, MultipartFile file) throws IOException {
       brandRepository.save(dtoToEntity(brandRequest,file));


    }

    @Override
    public BrandEntity dtoToEntity(BrandRequest brandRequest, MultipartFile file) throws IOException {


        BrandEntity brandEntity= new BrandEntity();

        //  CategoryEntity categoryEntity= categoryRepository.findByCategoryName(brandRequest.getCatNameId());

       // CategoryEntity categoryId = categoryRepository.findIdByCategoryName(brandRequest.getCatNameId());
        AttachmentEntity addImage=uploadImage(file);

       BeanUtils.copyProperties(brandRequest,brandEntity);

     //   System.out.println("brand category name id is : "+brandRequest.getCatNameId());

        System.out.println("brand Category name is : "+brandRequest.getCategoryName());
        brandEntity.setBrandName(brandRequest.getBrandName());
        brandEntity.setCategoryName(brandRequest.getCategoryName());
        brandEntity.setAttachmentEntity(addImage);


        return brandEntity;
    }

    @Override
    public AttachmentEntity uploadImage(MultipartFile file) throws IOException {

            String filePath= FOLDER_PATH+file.getOriginalFilename();

        AttachmentEntity attachmentEntity = attachmentRepository.save(AttachmentEntity.builder()
                .attachmentName(file.getOriginalFilename())
                .attachmentType(file.getContentType())
                .attachmentPath(filePath)
                .build());

        file.transferTo(new File(filePath));


        if(attachmentEntity ==null){

             throw new FileNotFoundException("this file doesn't exist here....");
        }

        return attachmentEntity;
    }

    @Override
    public List<BrandResponse> getAllBrand() {

        List<BrandResponse> getBrandList= new ArrayList<>();
        List<BrandEntity> brandEntityList = brandRepository.findAll();

        for(BrandEntity brandEntity : brandEntityList){
            var getBrand= entityToDto(brandEntity);
            getBrandList.add(getBrand);
        }

        return getBrandList;
    }

    @Override
    public List<BrandResponse> getBrandByCategory(String categoryName) {

        List<BrandResponse> getBrandListByCategory= new ArrayList<>();
        List<BrandEntity> getBrandByCategory= brandRepository.findBrandEntityByCategoryName(categoryName);

        for (BrandEntity brandEntity : getBrandByCategory){
            var getBrand= entityToDto(brandEntity);
            getBrandListByCategory.add(getBrand);
        }
        return getBrandListByCategory;
    }
   /* @Override
    public List<BrandEntity> getBrandByCategory(CategoryEntity catId) {

        List<BrandEntity> getBrandList= brandRepository.findByCatNameId(catId);

        return getBrandList;
    }*/

    @Override
    public BrandResponse entityToDto(BrandEntity brandEntity) {

        BrandResponse brandResponse= new BrandResponse();

        BeanUtils.copyProperties(brandEntity,brandResponse);

        brandResponse.setBrandName(brandEntity.getBrandName());
        brandResponse.setCatNameId(brandEntity.getCategoryName());

        return brandResponse;
    }


}
