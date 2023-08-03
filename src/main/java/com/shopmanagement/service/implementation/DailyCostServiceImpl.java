package com.shopmanagement.service.implementation;

import com.shopmanagement.dto.request.DailyCostRequest;
import com.shopmanagement.entity.DailyCostEntity;
import com.shopmanagement.repository.DailyCostRepository;
import com.shopmanagement.service.Definition.DailyCostServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DailyCostServiceImpl implements DailyCostServiceDefinition {



    @Autowired
    private DailyCostRepository dailyCostRepository;

    @Override
    public void addDailyCost(DailyCostRequest dailyCostRequest) {

        dailyCostRepository.save(dtoToEntity(dailyCostRequest));
    }

    @Override
    public void updateDailyCost(DailyCostRequest dailyCostRequest) {

        System.out.println("this is from daily cost service method...");
        dailyCostRepository.save(dtoToEntity(dailyCostRequest));
    }


    @Override
    public DailyCostEntity dtoToEntity(DailyCostRequest dailyCostRequest) {

        DailyCostEntity dailyCostEntity= new DailyCostEntity();

        BeanUtils.copyProperties(dailyCostRequest,dailyCostEntity);


        dailyCostEntity.setMorningSnack(dailyCostRequest.getMorningSnack());
        dailyCostEntity.setEveningSnack(dailyCostRequest.getEveningSnack());
        dailyCostEntity.setCustomerSnack(dailyCostRequest.getCustomerSnack());
        dailyCostEntity.setLaborCharge(dailyCostRequest.getLaborCharge());
        dailyCostEntity.setDailyDonation(dailyCostRequest.getDailyDonation());
        dailyCostEntity.setAddingDate(dailyCostRequest.getAddingDate());
        dailyCostEntity.setAddBy(dailyCostRequest.getAddBy());

        double totalDailyCost= dailyCostRequest.getMorningSnack()+dailyCostRequest.getEveningSnack()+
                                 dailyCostRequest.getCustomerSnack()+dailyCostRequest.getLaborCharge()
                                +dailyCostRequest.getDailyDonation()+dailyCostRequest.getOtherCost();

        dailyCostRequest.setTotalDailyCost(totalDailyCost);
        dailyCostEntity.setTotalDailyCost(dailyCostRequest.getTotalDailyCost());

        return dailyCostEntity;
    }

    @Override
    public DailyCostRequest entityToDto(DailyCostEntity dailyCostEntity) {
        return null;
    }

    @Override
    public List<DailyCostEntity> getAllDailyCost() {
        return dailyCostRepository.findAll();
    }

    @Override
    public DailyCostEntity getDailyCostById(Long dcId) {

        return dailyCostRepository.findById(dcId).get();
    }
}
