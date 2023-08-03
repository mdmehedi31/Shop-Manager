package com.shopmanagement.service.Definition;



import com.shopmanagement.dto.request.AddCustomerRequest;
import com.shopmanagement.dto.response.AddCustomerResponse;
import com.shopmanagement.entity.AddCustomerEntity;


import java.util.List;

public interface AddCustomerServiceDefinition {

    void addCustomer(AddCustomerRequest addCustomerRequest);
    List<AddCustomerResponse> getCustomerList();
    AddCustomerEntity dtoToEntity(AddCustomerRequest addCustomerRequest);

    AddCustomerResponse entityToDto(AddCustomerEntity addCustomerEntity);
}
