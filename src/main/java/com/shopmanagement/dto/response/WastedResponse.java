package com.shopmanagement.dto.response;

import com.shopmanagement.entity.BrandEntity;
import com.shopmanagement.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class WastedResponse {

    private CategoryEntity categoryNameId;
    private BrandEntity brandNameId;
    private double unitePrice;
    private double wastedAmount;
    private double totalWastedAmount;
    private String wastedReason;
    private String addedBy;
    private Date addedDate;
}
