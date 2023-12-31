package com.shopmanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RetailInvoiceResponse {

    private Long rvId;

    private String customerName;

    private String customerAddress;

    private String customerPhoneNumber;

    private LocalDateTime salesDate;

    private List<RetailInvoiceProductResponse> retailInvoiceProduct;

    private Double totalPayment;

    private Double duePayment;
    private Long totalProductQty;
}
