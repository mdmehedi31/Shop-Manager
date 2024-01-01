package com.shopmanagement.service.implementation;
import com.shopmanagement.dto.request.RetailInvoiceProductRequest;
import com.shopmanagement.dto.request.RetailInvoiceRequest;
import com.shopmanagement.dto.response.RetailInvoiceProductResponse;
import com.shopmanagement.dto.response.RetailInvoiceResponse;
import com.shopmanagement.entity.RetailInvoice;
import com.shopmanagement.entity.RetailInvoiceProduct;
import com.shopmanagement.entity.StockInEntity;
import com.shopmanagement.repository.RetailInvoiceProductRepository;
import com.shopmanagement.repository.RetailInvoiceRepository;
import com.shopmanagement.repository.StockInRepository;
import com.shopmanagement.service.Definition.RetailInvoiceServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class RetailInvoiceServiceImpl implements RetailInvoiceServiceDefinition {
    @Autowired
    private RetailInvoiceRepository retailInvoiceRepository;
    @Autowired
    private RetailInvoiceProductRepository retailInvoiceProductRepository;

    @Autowired
    private StockInRepository stockInRepository;
    @Override
    @Transactional()
    public String createRetailInvoice(RetailInvoiceRequest retailInvoiceRequest) {
       RetailInvoice retailInvoice= this.retailInvoiceRepository.save(dtoToEntity(retailInvoiceRequest));

        for(RetailInvoiceProductRequest ss : retailInvoiceRequest.getRetailInvoiceProduct()){
            RetailInvoiceProduct retailInvoiceProduct= new RetailInvoiceProduct();

            StockInEntity getStockOutProduct = this.stockInRepository.findByCategoryNameAndBrandNameAndProductName(ss.getCategoryName(),ss.getBrandName(),ss.getProductName());

            if(getStockOutProduct.getTotalProduct()>=ss.getTotalProductQuantity()){
                boolean isSellsValid= updateProductQuentity(getStockOutProduct,ss.getTotalProductQuantity());
                if(isSellsValid){
                    retailInvoiceProduct.setProductName(ss.getProductName());
                    retailInvoiceProduct.setBrandName(ss.getBrandName());
                    retailInvoiceProduct.setCategoryName(ss.getCategoryName());
                    retailInvoiceProduct.setQty(ss.getTotalProductQuantity());
                    retailInvoiceProduct.setProductPrice(ss.getProductPrice());
                    retailInvoiceProduct.setTotalProductPrice(ss.getTotalProductPrice());
                    retailInvoiceProduct.setRvId(retailInvoice.getRvId());
                    retailInvoiceProductRepository.save(retailInvoiceProduct);
                }else{
                    return "Product Out of the stock";
                }
            }
        }
        return "Save successfully";
    }

    private boolean updateProductQuentity(StockInEntity getStockOutProduct, Integer totalProductQuantity) {
    Integer updateProductQuentity= getStockOutProduct.getTotalProduct()-totalProductQuantity;
    getStockOutProduct.setTotalProduct(updateProductQuentity);

    StockInEntity updateProductQty= this.stockInRepository.save(getStockOutProduct);

    if(updateProductQty!=null){
        return true;
    }
    return false;
    }

    @Override
    public RetailInvoice dtoToEntity(RetailInvoiceRequest retailInvoiceRequest) {

        RetailInvoice retailInvoice = new RetailInvoice();

        BeanUtils.copyProperties(retailInvoiceRequest,retailInvoice);

        retailInvoice.setCustomerName(retailInvoiceRequest.getCustomerName());
        retailInvoice.setCustomerAddress(retailInvoiceRequest.getCustomerAddress());
        retailInvoice.setCustomerPhoneNumber(retailInvoiceRequest.getCustomerPhoneNumber());
        retailInvoice.setSalesDate(LocalDateTime.now());
        retailInvoice.setTotalProductQty(retailInvoiceRequest.getTotalProductQty());
        retailInvoice.setTotalPayment(retailInvoiceRequest.getTotalPayment());
        retailInvoice.setDuePayment(retailInvoiceRequest.getDuePayment());
        retailInvoice.setTotalProductQty(retailInvoiceRequest.getTotalProductQty());
        retailInvoice.setInvoiceNo(retailInvoiceRequest.getInvoiceNo());

        return retailInvoice;
    }

    @Override
    public List<RetailInvoiceResponse> getAllRetailInvoiceProduct() {
        List<RetailInvoiceResponse> getList= new ArrayList<>();
        List<RetailInvoice> getRetailInvoiceList= this.retailInvoiceRepository.findAll();

        for (RetailInvoice retailInvoice : getRetailInvoiceList){

           RetailInvoiceResponse retailInvoiceResponse = new RetailInvoiceResponse();
           retailInvoiceResponse.setRvId(retailInvoice.getRvId());
           retailInvoiceResponse.setCustomerName(retailInvoice.getCustomerName());
           retailInvoiceResponse.setCustomerAddress(retailInvoice.getCustomerAddress());
           retailInvoiceResponse.setCustomerPhoneNumber(retailInvoice.getCustomerPhoneNumber());
           retailInvoiceResponse.setSalesDate(retailInvoice.getSalesDate());
           retailInvoiceResponse.setTotalPayment(retailInvoiceResponse.getTotalPayment());
           retailInvoiceResponse.setDuePayment(retailInvoiceResponse.getDuePayment());
           retailInvoiceResponse.setTotalProductQty(retailInvoice.getTotalProductQty());

           List<RetailInvoiceProduct> getRetailInvoiceProductList= this.retailInvoiceProductRepository.findAllByRvId(retailInvoice.getRvId());

               List<RetailInvoiceProductResponse> retailInvoiceProductList = new ArrayList<>();
               for (RetailInvoiceProduct retailInvoiceProduct : getRetailInvoiceProductList){

                   RetailInvoiceProductResponse retailInvoiceProductResponse = new RetailInvoiceProductResponse();
                   retailInvoiceProductResponse.setProdId(retailInvoiceProduct.getProdId());
                   retailInvoiceProductResponse.setCategoryName(retailInvoiceProduct.getCategoryName());
                   retailInvoiceProductResponse.setBrandName(retailInvoiceProduct.getBrandName());
                   retailInvoiceProductResponse.setProductName(retailInvoiceProduct.getProductName());
                   retailInvoiceProductResponse.setProductQuantity(retailInvoiceProduct.getQty());
                   retailInvoiceProductResponse.setProductPrice(retailInvoiceProduct.getProductPrice());
                   retailInvoiceProductResponse.setTotalProductPrice(retailInvoiceProduct.getTotalProductPrice());

                   retailInvoiceProductList.add(retailInvoiceProductResponse);
               }
               retailInvoiceResponse.setRetailInvoiceProduct(retailInvoiceProductList);

            getList.add(retailInvoiceResponse);
        }
        return getList;
    }

    @Override
    public RetailInvoiceResponse getRetailInvoiceByInvoiceNo(String invoiceNo) {

        RetailInvoice retailInvoice = this.retailInvoiceRepository.findByInvoiceNo(invoiceNo);

        RetailInvoiceResponse retailInvoiceResponse = new RetailInvoiceResponse();
        retailInvoiceResponse.setRvId(retailInvoice.getRvId());
        retailInvoiceResponse.setCustomerName(retailInvoice.getCustomerName());
        retailInvoiceResponse.setCustomerAddress(retailInvoice.getCustomerAddress());
        retailInvoiceResponse.setCustomerPhoneNumber(retailInvoice.getCustomerPhoneNumber());
        retailInvoiceResponse.setSalesDate(retailInvoice.getSalesDate());
        retailInvoiceResponse.setTotalProductQty(retailInvoice.getTotalProductQty());
        retailInvoiceResponse.setTotalPayment(retailInvoice.getTotalPayment());
        retailInvoiceResponse.setDuePayment(retailInvoiceResponse.getDuePayment());

        List<RetailInvoiceProduct> getInvoiceProductList= this.retailInvoiceProductRepository.findAllByRvId(retailInvoice.getRvId());

        List<RetailInvoiceProductResponse> retailInvoiceProductResponseList = new ArrayList<>();
        for(RetailInvoiceProduct invoiceProduct : getInvoiceProductList){

            RetailInvoiceProductResponse retailInvoiceProductResponse = new RetailInvoiceProductResponse();

            retailInvoiceProductResponse.setProdId(invoiceProduct.getProdId());
            retailInvoiceProductResponse.setCategoryName(invoiceProduct.getCategoryName());
            retailInvoiceProductResponse.setBrandName(invoiceProduct.getBrandName());
            retailInvoiceProductResponse.setProductName(invoiceProduct.getProductName());
            retailInvoiceProductResponse.setProductPrice(invoiceProduct.getProductPrice());
            retailInvoiceProductResponse.setProductQuantity(invoiceProduct.getQty());
            retailInvoiceProductResponse.setTotalProductPrice(invoiceProduct.getTotalProductPrice());

            retailInvoiceProductResponseList.add(retailInvoiceProductResponse);
        }

        retailInvoiceResponse.setRetailInvoiceProduct(retailInvoiceProductResponseList);
        return retailInvoiceResponse;
    }
}
