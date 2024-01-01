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
@Table(name = "tb_wholesale_customer_info")
public class WholesaleCustomerInfo {
    @Id
    @Column(name = "wc_id")
    private Integer wcId;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "phone_no_one")
    private String phoneNoOne;
    @Column(name = "phone_no_two")
    private String phoneNoTwo;
    @Column(name = "location")
    private String location;
    @Column(name = "adding_date")
    private LocalDateTime addingDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
