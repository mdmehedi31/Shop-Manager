package com.shopmanagement.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DailyCostRequest {

    private Long dcId;
    private double morningSnack;
    private double eveningSnack;
    private double customerSnack;
    private double laborCharge;
    private double dailyDonation;
    private double otherCost;
    private Date addingDate;
    private String addBy;
    private double totalDailyCost;



    public Date getAddingDate(){

        return new Date();
    }
}
