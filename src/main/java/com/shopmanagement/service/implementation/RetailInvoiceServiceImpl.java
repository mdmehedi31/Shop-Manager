package com.shopmanagement.service.implementation;


import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.entity.RetailInvoice;
import com.shopmanagement.entity.RetailInvoiceProduct;
import com.shopmanagement.repository.RetailInvoiceProductRepository;
import com.shopmanagement.repository.RetailInvoiceRepository;
import com.shopmanagement.service.Definition.RetailInvoiceServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class RetailInvoiceServiceImpl implements RetailInvoiceServiceDefinition {


    @Autowired
    private RetailInvoiceRepository retailInvoiceRepository;

    @Autowired
    private RetailInvoiceProductRepository retailInvoiceProductRepository;

    @Override
    public String createRetailInvoice(RetailInvoiceRequest retailInvoiceRequest) {

       RetailInvoice retailInvoice= this.retailInvoiceRepository.save(dtoToEntity(retailInvoiceRequest));

       int i=1;
        for(RetailInvoiceProduct ss : retailInvoiceRequest.getRetailInvoiceProduct()){

            System.out.println(i+"th Category : "+ss.getCategoryName()+", Brand name "+ss.getBrandName()+
                    ", Product Name : "+ss.getProductName()+", Quantity : "+ss.getQty()+", Total Product Price : "+ss.getProductPrice());

            i++;
            RetailInvoiceProduct retailInvoiceProduct= new RetailInvoiceProduct();
            retailInvoiceProduct.setProductName(ss.getProductName());
            retailInvoiceProduct.setBrandName(ss.getBrandName());
            retailInvoiceProduct.setCategoryName(ss.getCategoryName());
            retailInvoiceProduct.setQty(ss.getQty());
            retailInvoiceProduct.setProductPrice(ss.getProductPrice());
            retailInvoiceProduct.setTotalProductPrice(ss.getTotalProductPrice());
            retailInvoiceProduct.setRetId(retailInvoice);

            retailInvoiceProductRepository.save(retailInvoiceProduct);
        }
        return "Save successfully";
    }

    @Override
    public RetailInvoice dtoToEntity(RetailInvoiceRequest retailInvoiceRequest) {

        RetailInvoice retailInvoice = new RetailInvoice();

        BeanUtils.copyProperties(retailInvoiceRequest,retailInvoice);

        retailInvoice.setCustomerName(retailInvoiceRequest.getCustomerName());
        retailInvoice.setCustomerAddress(retailInvoiceRequest.getCustomerAddress());
        retailInvoice.setCustomerPhoneNumber(retailInvoiceRequest.getCustomerPhoneNumber());
        retailInvoice.setSalesDate(retailInvoiceRequest.getLocalDateTime());
       // retailInvoice.setProduct(retailInvoiceRequest.getProduct());
        retailInvoice.setTotalProductQty(retailInvoiceRequest.getTotalProductQty());
        retailInvoice.setTotalPayment(retailInvoiceRequest.getTotalPayment());
        retailInvoice.setDuePayment(retailInvoiceRequest.getDuePayment());
        retailInvoice.setTotalProductQty(retailInvoice.getTotalProductQty());



        return retailInvoice;
    }
}
