package com.shopmanagement.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetailInvoiceProductResponse {

    private Long prodId;
    private String categoryName;
    private String brandName;
    private String productName;
    private double productPrice;
    private double productQuantity;
    private double totalProductPrice;

}
