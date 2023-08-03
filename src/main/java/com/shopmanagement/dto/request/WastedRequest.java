package com.shopmanagement.dto.request;

import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class WastedRequest {

    private CategoryEntity categoryNameId;
    private BrandEntity brandNameId;
    private double unitePrice;
    private double wastedAmount;
    private double totalWastedAmount;
    private String wastedReason;
    private String addedBy;
    private Date addedDate;
}
