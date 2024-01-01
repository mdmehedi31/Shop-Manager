package com.shopmanagement.controller.definitions;

import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.dto.response.RetailInvoiceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/retail-invoice")
@CrossOrigin("*")
public interface RetailInvoiceControllerDefinition {

    @PostMapping("/create")
    public String createRetailInvoice(@RequestBody RetailInvoiceRequest retailInvoiceRequest);

    @GetMapping("/get-all-retail-invoice-product")
    public List<RetailInvoiceResponse> getAllRetailInvoiceProductList();

    @GetMapping("/get-retail-invoice-by-invoice-no/{invoiceNo}")
    public RetailInvoiceResponse getRetailInvoiceByInvoiceNo(@PathVariable String invoiceNo);
}
