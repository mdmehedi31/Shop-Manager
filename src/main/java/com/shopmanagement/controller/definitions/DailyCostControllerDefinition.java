package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.DailyCostRequest;
import com.shopmanagement.entity.DailyCostEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/daily-cost")
@CrossOrigin("*")
public interface DailyCostControllerDefinition {

    @RequestMapping("/add-cost")
    void addDailyCost(@RequestBody DailyCostRequest dailyCostRequest);
    @RequestMapping("/getAll")
    List<DailyCostEntity> getAllList();

    @RequestMapping("/get-daily-cost/{dcId}")
    DailyCostEntity getDailyCost(@PathVariable("dcId") Long dcId);

    @PutMapping("/update-daily-cost")
    void updateDailyCost(@RequestBody DailyCostRequest dailyCostRequest);
}
