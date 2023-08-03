package com.shopmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbdailycost")
public class DailyCostEntity {


    @Id
    @Column(name = "dc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dcId;

    @Column(name = "morning_snack")
    private double morningSnack;
    @Column(name = "evening_snack")
    private double eveningSnack;
    @Column(name = "customer_snack")
    private double customerSnack;
    @Column(name = "labor_charge")
    private double laborCharge;
    @Column(name = "adding_date")
    private Date addingDate;
    @Column(name = "add_by")
    private String addBy;
    @Column(name = "dailyDonation")
    private double dailyDonation;
    @Column(name = "other_cost")
    private double otherCost;
    @Column(name = "total_daily_cost")
    private double totalDailyCost;
}
