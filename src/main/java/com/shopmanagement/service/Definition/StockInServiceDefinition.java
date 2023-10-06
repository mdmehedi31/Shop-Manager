package com.shopmanagement.service.Definition;


import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.StockInResponse;
import com.shopmanagement.entity.StockInEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface StockInServiceDefinition {



   Boolean saveStockIn(StockInRequest stockInRequest);
   StockInEntity dtoToEntity(StockInRequest stockInRequest);

   void updateStockIn(StockInRequest stockInRequest);

   void  deleteStockIn(Long stockId);
   StockInEntity getStockInById(Long stId);
   List<StockInResponse> getAllStockProduct();

   List<String> getProductByCategoryAndBrandName(String category, String brandName);

   Set<String> getOriginByCategoryName(String categoryName);
   StockInResponse entityToDto(StockInEntity stockInEntity);

   Boolean isExistByCategoryNameAndBrandNameAndProductName(String categoryName,String brandName,String productName);

   double getPriceByProductNameBrandNameCategoryName(String productName, String brandName, String categoryName);
}
