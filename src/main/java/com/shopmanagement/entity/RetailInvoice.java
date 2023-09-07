package com.shopmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "tbretail-invoice")
public class RetailInvoice {

    @Id
    @Column(name = "rvId")
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
//
//    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinTable(name = "status_attachments",
//            joinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "id")})
//    private List<Attachment> statusAttachmentList;


    @OneToMany(orphanRemoval = true, mappedBy = "retId")
    private Set<RetailInvoiceProduct> retailInvoiceProductList;

    @Column(name = "total_payment")
    private Double totalPayment;
    @Column(name = "due_payment")
    private Double duePayment;
    @Column(name = "total_product_qty")
    private Long totalProductQty;
}
