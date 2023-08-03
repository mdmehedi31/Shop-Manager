package com.shopmanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AddCustomerRequest {

    private Long addCusId;
    private String shopName;
    private String ownerName;
    private String shopLocation;
    private String phoneNo1;
    private String phoneNo2;
    private Date addingDate;
    private String addBy;


    public Date getAddingDate(){
        return new Date();
    }
}
