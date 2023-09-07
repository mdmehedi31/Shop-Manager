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

//    @ManyToOne(mappedBy="")
//    private RetailInvoice retailInvoice;

    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "brandName")
    private String brandName;
    @Column(name = "productName")
    private String productName;
    @Column(name = "qty")
    private int qty;
    @Column(name = "productPrice")
    private Long productPrice;
    @Column(name = "totalProductPrice")
    private Long totalProductPrice;

    @ManyToOne
    @JoinColumn(name = "rvId")
    private RetailInvoice retId;
}
