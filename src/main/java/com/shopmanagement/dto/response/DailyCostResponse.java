package com.shopmanagement.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DailyCostResponse {

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
}
