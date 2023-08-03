package com.shopmanagement.repository;

import com.shopmanagement.entity.StockInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface StockInRepository extends JpaRepository<StockInEntity,Long> {

    List<StockInEntity>  getProductNameByCategoryNameAndBrandName(String category,String brand);
    boolean existsByCategoryNameAndBrandNameAndProductName(String categoryName, String brandName,
                                                           String productName);

    StockInEntity findByCategoryNameAndBrandNameAndProductName(String categoryName, String brandName,
                                                               String productName);

    List<StockInEntity> getOriginByCategoryName(String categoryName);
}
