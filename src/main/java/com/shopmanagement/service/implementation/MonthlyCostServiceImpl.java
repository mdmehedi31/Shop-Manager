package com.shopmanagement.service.implementation;


import com.shopmanagement.dto.request.MonthlyCostRequest;
import com.shopmanagement.dto.response.MonthlyCostResponse;
import com.shopmanagement.entity.MonthlyCostEntity;
import com.shopmanagement.repository.MonthlyCostRepository;
import com.shopmanagement.service.Definition.MonthlyCostServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyCostServiceImpl implements MonthlyCostServiceDefinition {


    @Autowired
    private MonthlyCostRepository monthlyCostRepository;

    @Override
    public void addMonthlyCost(MonthlyCostRequest monthlyCostRequest) {
        monthlyCostRepository.save(dtoToEntity(monthlyCostRequest));
    }

    @Override
    public void updateMonthlyCost(MonthlyCostRequest monthlyCostRequest) {

        monthlyCostRepository.save(dtoToEntity(monthlyCostRequest));
    }

    @Override
    public MonthlyCostEntity dtoToEntity(MonthlyCostRequest monthlyCostRequest) {

        MonthlyCostEntity monthlyCostEntity = new MonthlyCostEntity();
        BeanUtils.copyProperties(monthlyCostRequest,monthlyCostEntity);


        monthlyCostEntity.setGuardSalary(monthlyCostRequest.getGuardSalary());
        monthlyCostEntity.setInternetPayment(monthlyCostRequest.getInternetPayment());
        monthlyCostEntity.setEmployeeSalary(monthlyCostRequest.getEmployeeSalary());
        monthlyCostEntity.setOtherCost(monthlyCostRequest.getOtherCost());
        double totalCost= monthlyCostRequest.getGuardSalary()+monthlyCostRequest.getInternetPayment()+
                          monthlyCostRequest.getEmployeeSalary()+monthlyCostRequest.getOtherCost();
        monthlyCostRequest.setTotalCost(totalCost);
        monthlyCostEntity.setTotalCost(monthlyCostRequest.getTotalCost());
        monthlyCostEntity.setMonthName(monthlyCostRequest.getMonthName());
        monthlyCostEntity.setAddBy(monthlyCostRequest.getAddBy());
        monthlyCostEntity.setAddingDate(monthlyCostRequest.getAddingDate());

        return monthlyCostEntity;
    }

    @Override
    public MonthlyCostResponse entityToDto(MonthlyCostEntity monthlyCostEntity) {
        return null;
    }

    @Override
    public List<MonthlyCostEntity> getAllMonthlyCost() {
        return monthlyCostRepository.findAll();
    }

    @Override
    public MonthlyCostEntity getMonthlyCostById(Long mcId) {
        return monthlyCostRepository.findById(mcId).get();
    }
}
