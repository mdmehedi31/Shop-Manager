package com.shopmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "wholesale_customer_invoice")
public class WholesaleCustomerInvoice {
    @Id
    @Column(name = "wc_invoice_id")
    private Integer wcInvoiceId;
    @Column(name = "invoice_id")
    private String invoiceId;
    @Column(name = "total_product")
    private Double totalProduct;
    @Column(name = "total_product_price")
    private Double totalProductPrice;
    @Column(name = "sales_date")
    private LocalDateTime salesDate;
    @Column(name = "wholesale_customer_info_id")
    private Integer wholesaleCustomerInfoId;
}
