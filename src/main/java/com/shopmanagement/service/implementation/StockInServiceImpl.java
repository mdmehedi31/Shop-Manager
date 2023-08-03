package com.shopmanagement.service.implementation;


import com.shopmanagement.dto.response.StockInResponse;

import com.shopmanagement.entity.StockInEntity;

import com.shopmanagement.repository.StockInRepository;
import com.shopmanagement.service.Definition.StockInServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockInServiceImpl implements StockInServiceDefinition {


    @Autowired
    private StockInRepository stockInRepository;

    @Override
    public Boolean saveStockIn(StockInEntity stockInRequest) {

         StockInEntity isExist= stockInRepository.findByCategoryNameAndBrandNameAndProductName(
                    stockInRequest.getCategoryName(),
                    stockInRequest.getBrandName(),
                    stockInRequest.getProductName()
         );

         if(isExist!=null){
             //System.out.println("is exist value is : "+isExist);
             return true;
         }
         else {

           //  System.out.println("is exits value is -1 : "+isExist);

             StockInEntity stockInEntity=dtoToEntity(stockInRequest);
             stockInEntity.setNewRate(0.0);
             stockInEntity.setNewProductAmount(0L);
            stockInRepository.save(stockInEntity);

            return false;

         }


    }

    @Override
    public StockInEntity dtoToEntity(StockInEntity stockInRequest) {

        StockInEntity stockInEntity= new StockInEntity();

        BeanUtils.copyProperties(stockInRequest,stockInEntity);

        stockInEntity.setBrandName(stockInRequest.getBrandName());
        stockInEntity.setCategoryName(stockInRequest.getCategoryName());
        stockInEntity.setProductName(stockInRequest.getProductName());
        stockInEntity.setOrigin(stockInRequest.getOrigin());
        stockInEntity.setStockInDate(stockInRequest.getStockInDate());
        stockInEntity.setStockInBy(stockInRequest.getStockInBy());
        stockInEntity.setTotalProduct(stockInRequest.getTotalProduct());
        stockInEntity.setUnitPrice(stockInRequest.getUnitPrice());
        stockInEntity.setTotalProductPrice(stockInRequest.
                getTotalProductPrice());
        stockInEntity.setProductDescription(stockInRequest.getProductDescription());
        stockInEntity.setUnitSellingPrice(stockInRequest.getUnitSellingPrice());
        stockInEntity.setShopProductAmount(stockInRequest.getShopProductAmount());
        stockInEntity.setShopShelfNo(stockInRequest.getShopShelfNo());
        stockInEntity.setShopShelfLevelNo(stockInRequest.getShopShelfLevelNo());
        stockInEntity.setWearHouseProductAmount(stockInRequest.getWearHouseProductAmount());
        stockInEntity.setWearHouseShelfNo(stockInRequest.getWearHouseShelfNo());
        stockInEntity.setWearHouseShelfLevelNo(stockInRequest.getWearHouseShelfLevelNo());
        stockInEntity.setNewRate(stockInRequest.getNewRate());
        stockInEntity.setNewProductAmount(stockInEntity.getNewProductAmount());




        return stockInEntity;
    }

    @Override
    public List<StockInResponse> getAllStockProduct() {


        List<StockInResponse> getStockInProductList = new ArrayList<>();

        List<StockInEntity> stockInEntityList = stockInRepository.findAll();

        for (StockInEntity stockInEntity : stockInEntityList){

            var stockInProduct= entityToDto(stockInEntity);

            getStockInProductList.add(stockInProduct);
        }

        for(StockInResponse st : getStockInProductList){

            System.out.println("Product name is : "+st.getProductName()+", Product quantity "+st.getTotalProduct());
        }
        return getStockInProductList;
    }

    @Override
    public List<String> getProductByCategoryAndBrandName(String category, String brandName) {

        List<String> productList= new ArrayList<>();
        List<StockInEntity> getProductList= stockInRepository.getProductNameByCategoryNameAndBrandName(category,brandName);

        for (StockInEntity stockInEntity: getProductList){
            var stock=entityToDto(stockInEntity);

            productList.add(stock.getProductName());
        }
        return productList;
    }

    @Override
    public List<String> getOriginByCategoryName(String categoryName) {

        List<String> originList= new ArrayList<>();

        List<StockInEntity> getOriginList= stockInRepository.getOriginByCategoryName(categoryName);

        for(StockInEntity origin: getOriginList){
            var originName=entityToDto(origin);

            originList.add(originName.getOrigin());
        }
        return originList;
    }

    @Override
    public StockInResponse entityToDto(StockInEntity stockInEntity) {

        StockInResponse stockInResponse = new StockInResponse();

        BeanUtils.copyProperties(stockInEntity,stockInResponse);

        stockInResponse.setCategoryName(String.valueOf(stockInEntity.getCategoryName()));
        stockInResponse.setBrandName(String.valueOf(stockInEntity.getBrandName()));
        stockInResponse.setProductName(stockInEntity.getProductName());
        stockInResponse.setUnitPrice(stockInEntity.getUnitPrice());
        stockInResponse.setTotalProduct(stockInEntity.getTotalProduct());
        stockInResponse.setTotalProductPrice(stockInEntity.getTotalProductPrice());
        stockInResponse.setProductDescription(stockInEntity.getProductDescription());
        stockInResponse.setUnitSellingPrice(stockInEntity.getUnitSellingPrice());
        stockInResponse.setShopProductAmount(stockInEntity.getShopProductAmount());
        stockInResponse.setShopShelfNo(stockInEntity.getShopShelfNo());
        stockInResponse.setShopShelfLevelNo(stockInEntity.getShopShelfLevelNo());
        stockInResponse.setWearHouseProductAmount(stockInEntity.getWearHouseProductAmount());
        stockInResponse.setWearHouseShelfNo(stockInEntity.getWearHouseShelfNo());
        stockInResponse.setWearHouseShelfLevelNo(stockInEntity.getWearHouseShelfLevelNo());
        stockInResponse.setStockInDate(stockInEntity.getStockInDate());
        stockInResponse.setStockInBy(stockInEntity.getStockInBy());
        stockInResponse.setNewRate(stockInEntity.getNewRate());
        stockInResponse.setNewProductAmount(stockInEntity.getNewProductAmount());



        return stockInResponse;
    }

    @Override
    public Boolean isExistByCategoryNameAndBrandNameAndProductName(String categoryName, String brandName, String productName) {


        boolean isExist= stockInRepository.existsByCategoryNameAndBrandNameAndProductName(categoryName,brandName,productName);

        return isExist;

    }
}
