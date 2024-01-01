package com.shopmanagement.service.Definition;


import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.dto.response.RetailInvoiceResponse;
import com.shopmanagement.entity.RetailInvoice;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RetailInvoiceServiceDefinition {

    String createRetailInvoice(@RequestBody RetailInvoiceRequest retailInvoiceRequest);

    RetailInvoice dtoToEntity(RetailInvoiceRequest retailInvoiceRequest);

    List<RetailInvoiceResponse> getAllRetailInvoiceProduct();

    public RetailInvoiceResponse getRetailInvoiceByInvoiceNo(String invoiceNo);

}
