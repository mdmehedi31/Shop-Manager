package com.shopmanagement.controller.implementation;


import com.shopmanagement.controller.definitions.MonthlyCostControllerDefinition;


import com.shopmanagement.dto.request.MonthlyCostRequest;
import com.shopmanagement.entity.MonthlyCostEntity;
import com.shopmanagement.service.Definition.MonthlyCostServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonthlyCostControllerImpl implements MonthlyCostControllerDefinition {


    @Autowired
    private MonthlyCostServiceDefinition monthlyCostServiceDefinition;

    @Override
    public List<MonthlyCostEntity> getMonthlyCostList() {
        return monthlyCostServiceDefinition.getAllMonthlyCost();
    }

    @Override
    public void addMonthlyCost(MonthlyCostRequest monthlyCostRequest) {

        monthlyCostServiceDefinition.addMonthlyCost(monthlyCostRequest);
    }

    @Override
    public MonthlyCostEntity getMonthlyCostById(Long mcId) {

        System.out.println("Your Get Monthly Cost Get row id is "+mcId);
        return monthlyCostServiceDefinition.getMonthlyCostById(mcId);
    }

    @Override
    public void updateMonthlyCost(MonthlyCostRequest monthlyCostRequest) {

        monthlyCostServiceDefinition.updateMonthlyCost(monthlyCostRequest);
    }
}
