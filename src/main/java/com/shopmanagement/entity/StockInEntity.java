package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbstockin")
public class StockInEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long stockId;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandNameId", referencedColumnName = "brandId")*/
   /* @JoinTable(name = "stockin_brand",
            joinColumns ={@JoinColumn(name = "stockin_id",referencedColumnName = "stock_id")},
            inverseJoinColumns = {@JoinColumn(name = "stockin_brandId",referencedColumnName = "brandId")}   )
    private BrandEntity brandName;
  */

  @Column(name = "brandName")
  private String brandName;
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryNameId", referencedColumnName = "catId")*/
   /* @JoinTable(name = "stockin_category",
      joinColumns = {@JoinColumn(name = "stockin_id",referencedColumnName = "stock_id")},
        inverseJoinColumns = {@JoinColumn(name = "stockin_cat_id", referencedColumnName = "catId")})
       private String categoryName */


    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "origin")
    private String origin;

    @Column(name = "total_product")
    private int totalProduct;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name = "total_price")
    private double totalProductPrice;

    @Column(name = "product_desc")
    private String productDescription;

    @Column(name = "unit_Selling_Price")
    private double unitSellingPrice;

    @Column(name = "shop_product_amount")
    private int shopProductAmount;

    @Column(name = "shop_Shelf_No")
    private String shopShelfNo;

    @Column(name = "shop_shelf_level_no")
    private String shopShelfLevelNo;

    @Column(name = "wear_house_product_amount")
    private int wearHouseProductAmount;

    @Column(name = "wear_house_shelf_no")
    private String wearHouseShelfNo;

    @Column(name = "wear_house_shelf_level_no")
    private String wearHouseShelfLevelNo;

    @Column(name = "stock_in_date")
    private Date stockInDate;

    @Column(name = "stock_in_by")
    private String stockInBy;

    @Column(name = "new_rate")
    private Double newUnitRate=0.0;

    @Column(name = "new_product_amount")
    private int newProductAmount;

    @Column(name = "update_stock_in_date")
    private Date updateStockInDate;
}
