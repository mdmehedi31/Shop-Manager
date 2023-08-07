package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.StockInResponse;
import com.shopmanagement.entity.StockInEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/stock-in")
@CrossOrigin("*")
public interface StockInControllerDefinition {



    @RequestMapping("/add-stock")
    Boolean addStock(@RequestBody StockInRequest stockInRequest);
    @RequestMapping("/get-stock/{id}")
    StockInEntity getStockById(@PathVariable Long id);

    @PutMapping("/update-stock")
    void updateStock(@RequestBody StockInRequest stockInRequest);
    @DeleteMapping("/delete-stock/{id}")
    void deleteStock(@PathVariable Long id);
    @RequestMapping("/get-product-list/{categoryName}/{brandName}")
    List<String> getProductByCategoryAndBrandName(@PathVariable String categoryName,@PathVariable String brandName);
    @RequestMapping("/stock-product-list")
    List<StockInResponse> getStockInProductList();

    @GetMapping("/is-exist/{categoryName}/{brandName}/{productName}")
    Boolean isExistByCategoryNameAndBrandNameAndProductName(@PathVariable String categoryName,@PathVariable String brandName,
                                                                                @PathVariable String productName);
    @RequestMapping("/get-origin/{categoryName}")
    Set<String> getOriginByCategoryName(@PathVariable String categoryName);

    //List<String> getOriginByCategoryAndBrandNameAndProductName();

}
