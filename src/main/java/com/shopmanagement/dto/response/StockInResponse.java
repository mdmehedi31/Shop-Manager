package com.shopmanagement.dto.response;


import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StockInResponse {

    private Long stockId;
    private String brandName;
    private String categoryName;
    private String productName;
    private String origin;
    private int totalProduct;
    private Double unitPrice;
    private Double totalProductPrice;
    private String productDescription;
    private double unitSellingPrice;
    private int shopProductAmount;
    private String shopShelfNo;
    private String shopShelfLevelNo;
    private int wearHouseProductAmount;
    private String wearHouseShelfNo;
    private String wearHouseShelfLevelNo;
    private Date stockInDate;
    private String stockInBy;
    private Double newUnitRate;
    private int newProductAmount;
    private Date updateStockInDate;



}
