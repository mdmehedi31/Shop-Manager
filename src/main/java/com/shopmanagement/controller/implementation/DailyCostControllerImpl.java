package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.DailyCostControllerDefinition;
import com.shopmanagement.dto.request.DailyCostRequest;
import com.shopmanagement.entity.DailyCostEntity;
import com.shopmanagement.service.Definition.DailyCostServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DailyCostControllerImpl implements DailyCostControllerDefinition {


    @Autowired
    private DailyCostServiceDefinition dailyCostServiceDefinition;


    @Override
    public void addDailyCost(DailyCostRequest dailyCostRequest) {

        dailyCostServiceDefinition.addDailyCost(dailyCostRequest);
    }

    @Override
    public List<DailyCostEntity> getAllList() {

        return dailyCostServiceDefinition.getAllDailyCost();
    }

    @Override
    public DailyCostEntity getDailyCost(Long dcId) {
        return dailyCostServiceDefinition.getDailyCostById(dcId);
    }

    @Override
    public void updateDailyCost(DailyCostRequest dailyCostRequest) {

        System.out.println("this is from daily cost controller update method....");
        dailyCostServiceDefinition.updateDailyCost(dailyCostRequest);
    }
}
