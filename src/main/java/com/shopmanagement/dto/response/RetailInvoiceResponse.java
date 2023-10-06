package com.shopmanagement.dto.response;

import com.shopmanagement.entity.RetailInvoiceProduct;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class RetailInvoiceResponse {

    private Long rvId;

    private String customerName;


    private String customerAddress;


    private String customerPhoneNumber;

    private LocalDateTime localDateTime;

    private Set<RetailInvoiceProduct> retailInvoiceProduct;

    private Double totalPayment;

    private Double duePayment;
    private Long totalProductQty;
}
