package com.shopmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "tbretail_invoice")
public class RetailInvoice {

    @Id
    @Column(name = "rv_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rvId;

    @Column(name="invoiceNo")
    private String invoiceNo;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_phone_Number")
    private String customerPhoneNumber;
    @Column(name = "sales_date")
    private LocalDateTime salesDate;
    @Column(name = "total_payment")
    private Double totalPayment;
    @Column(name = "due_payment")
    private Double duePayment;
    @Column(name = "total_product_qty")
    private Long totalProductQty;
}
