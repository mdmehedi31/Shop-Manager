package com.shopmanagement.service.Definition;


import com.shopmanagement.dto.request.DailyCostRequest;
import com.shopmanagement.entity.DailyCostEntity;

import java.util.List;

public interface DailyCostServiceDefinition {


    void addDailyCost(DailyCostRequest dailyCostRequest);

    void updateDailyCost(DailyCostRequest dailyCostRequest);

    DailyCostEntity dtoToEntity(DailyCostRequest dailyCostRequest);


    DailyCostRequest entityToDto(DailyCostEntity dailyCostEntity);

    List<DailyCostEntity> getAllDailyCost();

    DailyCostEntity getDailyCostById(Long dcId);
}

