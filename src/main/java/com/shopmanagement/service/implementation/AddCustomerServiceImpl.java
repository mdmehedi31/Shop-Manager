package com.shopmanagement.service.implementation;

import com.shopmanagement.dto.request.AddCustomerRequest;
import com.shopmanagement.dto.response.AddCustomerResponse;
import com.shopmanagement.entity.AddCustomerEntity;
import com.shopmanagement.repository.AddCustomerRepository;
import com.shopmanagement.service.Definition.AddCustomerServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddCustomerServiceImpl implements AddCustomerServiceDefinition {


    @Autowired
    private AddCustomerRepository addCustomerRepository;



    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest) {

        addCustomerRepository.save(dtoToEntity(addCustomerRequest));
    }

    @Override
    public List<AddCustomerResponse> getCustomerList() {


        List<AddCustomerResponse> getCustomerList= new ArrayList<>();
        List<AddCustomerEntity> getCustomerEntityList= addCustomerRepository.findAll();
        for(AddCustomerEntity addCustomer : getCustomerEntityList){

            var getCustomer= entityToDto(addCustomer);

            getCustomerList.add(getCustomer);
        }

        return getCustomerList;
    }

    @Override
    public AddCustomerEntity dtoToEntity(AddCustomerRequest addCustomerRequest) {

        AddCustomerEntity addCustomerEntity= new AddCustomerEntity();

        BeanUtils.copyProperties(addCustomerRequest, addCustomerEntity);

        addCustomerEntity.setShopName(addCustomerRequest.getShopName());
        addCustomerEntity.setOwnerName(addCustomerRequest.getOwnerName());
        addCustomerEntity.setShopLocation(addCustomerRequest.getShopLocation());
        addCustomerEntity.setPhoneNo1(addCustomerRequest.getPhoneNo1());
        addCustomerEntity.setPhoneNo2(addCustomerRequest.getPhoneNo2());
        addCustomerEntity.setAddingDate(addCustomerRequest.getAddingDate());
        addCustomerEntity.setAddBy(addCustomerRequest.getAddBy());


        return addCustomerEntity;
    }

    @Override
    public AddCustomerResponse entityToDto(AddCustomerEntity addCustomerEntity) {


        AddCustomerResponse addCustomerResponse= new AddCustomerResponse();

        BeanUtils.copyProperties(addCustomerEntity,addCustomerResponse);

        addCustomerResponse.setShopName(addCustomerEntity.getShopName());
        addCustomerResponse.setOwnerName(addCustomerEntity.getOwnerName());
        addCustomerResponse.setShopLocation(addCustomerEntity.getShopLocation());
        addCustomerResponse.setPhoneNo1(addCustomerEntity.getPhoneNo1());
        addCustomerResponse.setPhoneNo2(addCustomerEntity.getPhoneNo2());
        addCustomerResponse.setAddingDate(addCustomerEntity.getAddingDate());
        addCustomerResponse.setAddBy(addCustomerEntity.getAddBy());

        return addCustomerResponse;
    }
}
