package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Getter
@Setter
@Entity
@Table(name = "tbaddcustomer")
public class AddCustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addCusId")
    private Long addCusId;

    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "shop_location")
    private String shopLocation;
    @Column(name = "phone_no1")
    private String phoneNo1;
    @Column(name = "phone_no2")
    private String phoneNo2;
    @Column(name = "adding_date")
    private Date addingDate;
    @Column(name = "add_by")
    private String addBy;
}
