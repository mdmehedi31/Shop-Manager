package com.shopmanagement.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MonthlyCostResponse {

    private Long mcId;
    private double internetPayment;
    private double guardSalary;
    private double employeeSalary;
    private double otherCost;
    private String monthName;
    private double totalCost;
    private Date addingDate;
    private String addBy;
}
