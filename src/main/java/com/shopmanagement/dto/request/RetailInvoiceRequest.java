package com.shopmanagement.dto.request;


import com.shopmanagement.entity.RetailInvoiceProduct;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RetailInvoiceRequest {
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private List<RetailInvoiceProductRequest> retailInvoiceProduct;
    private Double totalPayment;
    private Double duePayment;
    private Long totalProductQty;
    private String invoiceNo;
}




