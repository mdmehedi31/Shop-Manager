package com.shopmanagement.controller.definitions;

import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.entity.RetailInvoice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/retail-invoice")
@CrossOrigin("*")
public interface RetailInvoiceControllerDefinition {

    @PostMapping("/create")
    String createRetailInvoice(@RequestBody RetailInvoiceRequest retailInvoiceRequest);
}
