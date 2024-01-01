package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbretail_invoice_product")
public class RetailInvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prodID")
    private Long prodId;

    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "brandName")
    private String brandName;
    @Column(name = "productName")
    private String productName;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "totalProductPrice")
    private double totalProductPrice;
    @Column(name = "rvId")
    private Long rvId;
}
