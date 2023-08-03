package com.shopmanagement.dto.request;


import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StockInRequest {

    private Long stockId;
    private String brandName;
    private String categoryName;
    private String productName;
    private String origin;
    private Date stockInDate;
    private String stockInBy;
    private String productDescription;
    private Long totalProduct;
    private double unitPrice;
    private double totalProductPrice;
    private double unitSellingPrice;
    private int shopProductAmount;
    private String shopShelfNo;
    private String shopShelfLevelNo;
    private int wearHouseProductAmount;
    private String wearHouseShelfNo;
    private String wearHouseShelfLevelNo;
    private Double newRate;
    private Long newProductAmount;

}
