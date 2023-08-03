package com.shopmanagement.service.Definition;

import com.shopmanagement.dto.request.MonthlyCostRequest;
import com.shopmanagement.dto.response.MonthlyCostResponse;
import com.shopmanagement.entity.MonthlyCostEntity;

import java.util.List;

public interface MonthlyCostServiceDefinition {


    void addMonthlyCost(MonthlyCostRequest monthlyCostRequest);
    void updateMonthlyCost(MonthlyCostRequest monthlyCostRequest);
    MonthlyCostEntity dtoToEntity(MonthlyCostRequest monthlyCostRequest);
    MonthlyCostResponse entityToDto(MonthlyCostEntity monthlyCostEntity);
    List<MonthlyCostEntity> getAllMonthlyCost();

    MonthlyCostEntity getMonthlyCostById(Long mcId);

}

