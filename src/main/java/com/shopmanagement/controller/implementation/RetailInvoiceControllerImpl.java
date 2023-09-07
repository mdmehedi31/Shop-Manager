package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.RetailInvoiceControllerDefinition;
import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.entity.RetailInvoice;
import com.shopmanagement.service.Definition.RetailInvoiceServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailInvoiceControllerImpl implements RetailInvoiceControllerDefinition {

    @Autowired
    private RetailInvoiceServiceDefinition retailInvoiceServiceDefinition;

    @Override
    public String createRetailInvoice(RetailInvoiceRequest retailInvoiceRequest) {
        System.out.println("this is from Retail invoice controller imple..");
        return retailInvoiceServiceDefinition.createRetailInvoice(retailInvoiceRequest);
    }
}
