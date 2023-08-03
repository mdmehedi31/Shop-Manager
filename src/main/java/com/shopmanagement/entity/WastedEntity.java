package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbwasted")
public class WastedEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wasted_id")
    private Long wastedId;

  /*  @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryName_id", referencedColumnName = "catId")*/
    private String categoryNameId;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandName_id", referencedColumnName = "brandId")*/
    private String brandNameId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "unite_price")
    private double unitePrice;

    @Column(name = "wasted_amount")
    private double wastedAmount;

    @Column(name = "total_wasted_amount")
    private double totalWastedAmount;

    @Column(name = "wasted_reason")
    private String wastedReason;

    @Column(name = "added_by")
    private String addedBy;

    @Column(name = "added_date")
    private Date addedDate;
}
