package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.StockInResponse;
import com.shopmanagement.entity.StockInEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stock-in")
@CrossOrigin("*")
public interface StockInControllerDefinition {



    @RequestMapping("/add-stock")
    Boolean addStock(@RequestBody StockInEntity stockInRequest);
    @RequestMapping("/update-stock/{id}")
    String updateStock(@RequestBody StockInRequest stockInRequest);
    @RequestMapping("/delete-stock/{id}")
    String deleteStock(@PathVariable Long id);
    @RequestMapping("/get-product-list/{categoryName}/{brandName}")
    List<String> getProductByCategoryAndBrandName(@PathVariable String categoryName,@PathVariable String brandName);
    @RequestMapping("/stock-product-list")
    List<StockInResponse> getStockInProductList();

    @GetMapping("/is-exist/{categoryName}/{brandName}/{productName}")
    Boolean isExistByCategoryNameAndBrandNameAndProductName(@PathVariable String categoryName,@PathVariable String brandName,
                                                                                @PathVariable String productName);


    @RequestMapping("/get-origin/{categoryName}")
    List<String> getOriginByCategoryName(@PathVariable String categoryName);
}
