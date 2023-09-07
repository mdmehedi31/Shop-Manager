package com.shopmanagement.service.Definition;


import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.entity.RetailInvoice;
import org.springframework.web.bind.annotation.RequestBody;

public interface RetailInvoiceServiceDefinition {

    String createRetailInvoice(@RequestBody RetailInvoiceRequest retailInvoiceRequest);

    RetailInvoice dtoToEntity(RetailInvoiceRequest retailInvoiceRequest);



}
