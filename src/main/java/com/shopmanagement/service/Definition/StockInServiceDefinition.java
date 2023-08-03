package com.shopmanagement.service.Definition;


import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.StockInResponse;
import com.shopmanagement.entity.StockInEntity;
import org.springframework.stereotype.Service;

import java.util.List;



public interface StockInServiceDefinition {



   Boolean saveStockIn(StockInEntity stockInRequest);
   StockInEntity dtoToEntity(StockInEntity stockInRequest);

   List<StockInResponse> getAllStockProduct();

   List<String> getProductByCategoryAndBrandName(String category, String brandName);

   List<String> getOriginByCategoryName(String categoryName);
   StockInResponse entityToDto(StockInEntity stockInEntity);

   Boolean isExistByCategoryNameAndBrandNameAndProductName(String categoryName,

                                                                            String brandName,String productName);

}
