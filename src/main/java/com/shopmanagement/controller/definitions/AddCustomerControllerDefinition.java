package com.shopmanagement.controller.definitions;


import com.shopmanagement.dto.request.AddCustomerRequest;
import com.shopmanagement.dto.response.AddCustomerResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/add-customer")
@CrossOrigin("*")
public interface AddCustomerControllerDefinition {
    @RequestMapping("/create")
    public void addCustomer(@RequestBody AddCustomerRequest addCustomerRequest);
    @RequestMapping("/customer-list")
    public List<AddCustomerResponse> getCustomerList();
}
