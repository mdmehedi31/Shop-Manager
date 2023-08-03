package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.AddCustomerControllerDefinition;
import com.shopmanagement.dto.request.AddCustomerRequest;
import com.shopmanagement.dto.response.AddCustomerResponse;
import com.shopmanagement.service.Definition.AddCustomerServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AddCustomerControllerImpl implements AddCustomerControllerDefinition {


    @Autowired
    private AddCustomerServiceDefinition addCustomerServiceDefinition;

    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest) {

        addCustomerServiceDefinition.addCustomer(addCustomerRequest);
    }

    @Override
    public List<AddCustomerResponse> getCustomerList() {

        return addCustomerServiceDefinition.getCustomerList();
    }
}
