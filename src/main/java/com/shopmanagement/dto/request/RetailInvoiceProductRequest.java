package com.shopmanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetailInvoiceProductRequest {

    private String categoryName;
    private String brandName;
    private String productName;
    private double productPrice;
    private double totalProductPrice;
    private Integer totalProductQuantity;
}
