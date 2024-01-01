package com.shopmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_wholesale_product_list")
public class WholesaleProductList {

    @Id
    @Column(name = "wps_id")
    private Integer wspId;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "sales_date")
    private LocalDateTime salesDate;
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "customer_id")
    private Integer customerId;
}
