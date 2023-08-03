package com.shopmanagement.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MonthlyCostRequest {

    private Long mcId;
    private double internetPayment;
    private double guardSalary;
    private double employeeSalary;
    private double otherCost;
    private String monthName;
    private double totalCost;
    private Date addingDate;
    private String addBy;

    public Date getAddingDate(){
        return new Date();
    }
}
