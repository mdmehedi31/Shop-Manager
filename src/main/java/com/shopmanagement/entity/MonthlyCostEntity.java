package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbmonthlycost")
public class MonthlyCostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mcId")
    private Long mcId;
    @Column(name = "internet_payment")
    private double internetPayment;
    @Column(name = "guard_salary")
    private double guardSalary;
    @Column(name = "employee_salary")
    private double employeeSalary;
    @Column(name = "other_cost")
    private double otherCost;
    @Column(name = "month_name")
    private String monthName;
    @Column(name = "total_cost")
    private double totalCost;
    @Column(name = "adding_date")
    private Date addingDate;
    @Column(name = "add_by")
    private String addBy;

}
