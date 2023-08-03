package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.MonthlyCostRequest;
import com.shopmanagement.entity.MonthlyCostEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/monthly-cost")
@CrossOrigin("*")
public interface MonthlyCostControllerDefinition {


    @RequestMapping("/get-monthly-cost-list")
    List<MonthlyCostEntity> getMonthlyCostList();
    @RequestMapping("/add-cost")
    void addMonthlyCost(@RequestBody MonthlyCostRequest monthlyCostRequest);

    @RequestMapping("/get-monthly-cost/{mcId}")
    MonthlyCostEntity getMonthlyCostById(@PathVariable("mcId") Long mcId);

    @PutMapping("/update-monthly-cost")
    void updateMonthlyCost(@RequestBody MonthlyCostRequest monthlyCostRequest);


}
