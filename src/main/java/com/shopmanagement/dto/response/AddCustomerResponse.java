package com.shopmanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AddCustomerResponse {

    private Long addCusId;
    private String shopName;
    private String ownerName;
    private String shopLocation;
    private String phoneNo1;
    private String phoneNo2;
    private Date addingDate;
    private String addBy;
}
