package com.shopmanagement.repository;

import com.shopmanagement.entity.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface BrandRepository extends JpaRepository<BrandEntity,Long> {


 //  List<BrandEntity> findByCatNameId(CategoryEntity catId);

    List<BrandEntity> findBrandEntityByCategoryName(String categoryName);



}
