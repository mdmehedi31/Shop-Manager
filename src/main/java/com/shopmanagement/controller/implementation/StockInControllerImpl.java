package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.StockInControllerDefinition;
import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.dto.response.StockInResponse;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.entity.StockInEntity;
import com.shopmanagement.service.Definition.StockInServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockInControllerImpl implements StockInControllerDefinition {


    @Autowired
    private StockInServiceDefinition stockInServiceDefinition;




    @Override
    public Boolean addStock(StockInEntity stockInRequest) {

        System.out.println("this is from add stock method..");
       return stockInServiceDefinition.saveStockIn(stockInRequest);

    }

    @Override
    public String updateStock(StockInRequest stockInRequest) {

        return null;
    }

    @Override
    public String deleteStock(Long id) {
        return null;
    }

    @Override
    public List<String> getProductByCategoryAndBrandName(String categoryName, String brandName) {

        return stockInServiceDefinition.getProductByCategoryAndBrandName(categoryName,brandName);
    }

    @Override
    public List<StockInResponse> getStockInProductList() {

      //  System.out.println("this is from stock in controller implementation...");
        return stockInServiceDefinition.getAllStockProduct();
    }

    @Override
    public Boolean isExistByCategoryNameAndBrandNameAndProductName(String categoryName, String brandName, String productName) {
        System.out.println("From Stock in get stock in controller method..");

        return stockInServiceDefinition.isExistByCategoryNameAndBrandNameAndProductName(categoryName,brandName,productName);
    }

    @Override
    public List<String> getOriginByCategoryName(String categoryName) {

        return stockInServiceDefinition.getOriginByCategoryName(categoryName);
    }
}
