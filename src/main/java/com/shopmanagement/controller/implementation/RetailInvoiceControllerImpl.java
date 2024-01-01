package com.shopmanagement.controller.implementation;

import com.shopmanagement.controller.definitions.RetailInvoiceControllerDefinition;
import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.dto.response.RetailInvoiceResponse;
import com.shopmanagement.service.Definition.RetailInvoiceServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailInvoiceControllerImpl implements RetailInvoiceControllerDefinition {

    @Autowired
    private RetailInvoiceServiceDefinition retailInvoiceServiceDefinition;

    @Override
    public String createRetailInvoice(RetailInvoiceRequest retailInvoiceRequest) {
        System.out.println("this is from Retail invoice controller imple..");
        return retailInvoiceServiceDefinition.createRetailInvoice(retailInvoiceRequest);
    }

    @Override
    public List<RetailInvoiceResponse> getAllRetailInvoiceProductList() {

        return this.retailInvoiceServiceDefinition.getAllRetailInvoiceProduct();
    }

    @Override
    public RetailInvoiceResponse getRetailInvoiceByInvoiceNo(String invoiceNo) {
        return this.retailInvoiceServiceDefinition.getRetailInvoiceByInvoiceNo(invoiceNo);
    }
}
