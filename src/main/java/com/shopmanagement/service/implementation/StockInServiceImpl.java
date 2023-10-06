package com.shopmanagement.service.implementation;


import com.shopmanagement.dto.request.StockInRequest;
import com.shopmanagement.dto.response.StockInResponse;

import com.shopmanagement.entity.StockInEntity;

import com.shopmanagement.repository.StockInRepository;
import com.shopmanagement.service.Definition.StockInServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StockInServiceImpl implements StockInServiceDefinition {


    @Autowired
    private StockInRepository stockInRepository;

    @Override
    public Boolean saveStockIn(StockInRequest stockInRequest) {

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
             stockInEntity.setNewUnitRate(0.0);
             stockInEntity.setNewProductAmount(0);
            stockInRepository.save(stockInEntity);

            return false;

         }


    }

    @Override
    public StockInEntity dtoToEntity(StockInRequest stockInRequest) {

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
        stockInEntity.setNewUnitRate(stockInRequest.getNewUnitRate());
        stockInEntity.setNewProductAmount(stockInRequest.getNewProductAmount());
        stockInEntity.setUpdateStockInDate(stockInRequest.getUpdateStockInDate());

        return stockInEntity;
    }

    @Override
    public void updateStockIn(StockInRequest stockInRequest) {

        this.stockInRepository.save(dtoToEntityUpdateStockIn(stockInRequest));
    }

    @Override
    public void deleteStockIn(Long stockId) {

        StockInEntity stockInEntity = new StockInEntity();
        stockInEntity.setStockId(stockId);

        this.stockInRepository.delete(stockInEntity);

    }


    @Override
    public StockInEntity getStockInById(Long stId) {

        return this.stockInRepository.findById(stId).get();
    }

    @Override
    public List<StockInResponse> getAllStockProduct() {


        List<StockInResponse> getStockInProductList = new ArrayList<>();

        List<StockInEntity> stockInEntityList = stockInRepository.findAll();

        for (StockInEntity stockInEntity : stockInEntityList){

            var stockInProduct= entityToDto(stockInEntity);

            getStockInProductList.add(stockInProduct);
        }

//        for(StockInResponse st : getStockInProductList){
//
//            System.out.println("Product name is : "+st.getProductName()+", Product quantity "+st.getTotalProduct());
//        }
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
    public Set<String> getOriginByCategoryName(String categoryName) {

        Set<String> originList= new HashSet<>();

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
        stockInResponse.setNewUnitRate(stockInEntity.getNewUnitRate());
        stockInResponse.setNewProductAmount(stockInEntity.getNewProductAmount());
        stockInResponse.setUpdateStockInDate(stockInEntity.getUpdateStockInDate());

        return stockInResponse;
    }

    @Override
    public Boolean isExistByCategoryNameAndBrandNameAndProductName(String categoryName, String brandName, String productName) {


        boolean isExist= stockInRepository.existsByCategoryNameAndBrandNameAndProductName(categoryName,brandName,productName);

        return isExist;

    }

    @Override
    public double getPriceByProductNameBrandNameCategoryName(String productName, String brandName, String categoryName) {

        double price;

        price= this.stockInRepository.getUnitSellingPriceByProductNameAndBrandNameAndCategoryName(productName,brandName,categoryName);
        System.out.println("Price is "+price);
        return price;
    }


    private StockInEntity dtoToEntityUpdateStockIn(StockInRequest stockInRequest){


        System.out.println("this is from dtoToEntityUpdateStockIn method in stock in service impl");
        StockInEntity stockInEntity = new StockInEntity();

        BeanUtils.copyProperties(stockInRequest,stockInEntity);


        stockInEntity.setBrandName(stockInRequest.getBrandName());
        stockInEntity.setCategoryName(stockInRequest.getCategoryName());
        stockInEntity.setProductName(stockInRequest.getProductName());
        stockInEntity.setOrigin(stockInRequest.getOrigin());
        stockInEntity.setStockInDate(stockInRequest.getStockInDate());
        stockInEntity.setStockInBy(stockInRequest.getStockInBy());

        stockInEntity.setUnitPrice(stockInRequest.getUnitPrice());

        if(stockInRequest.getNewUnitRate()==stockInRequest.getUnitPrice()){

            int total_product= stockInRequest.getTotalProduct()+stockInRequest.getNewProductAmount();

            stockInEntity.setTotalProduct(total_product);
            Double totalProductPrice= stockInRequest.getTotalProductPrice() + (stockInRequest.getNewProductAmount()*stockInRequest.getUnitPrice());

            stockInEntity.setTotalProductPrice(totalProductPrice);
            stockInEntity.setNewProductAmount(0);
            stockInEntity.setNewUnitRate(0.0);

            System.out.println("this is from stock in service impl dtoToEntityUpdateStockIn() method..");
            System.out.println("product id : "+stockInRequest.getStockId()+"\n"+" total Product "+ total_product+"\n"+" total product price : "+totalProductPrice
                            +"\n"+" new Product amount is "+stockInEntity.getNewProductAmount()+"\n"
                            +"new unit rate "+stockInEntity.getNewUnitRate());
        }else{

            int total_product= stockInRequest.getTotalProduct()+stockInRequest.getNewProductAmount();
            stockInEntity.setTotalProduct(total_product);
            Double totalProductPrice= stockInRequest.getTotalProductPrice() + (stockInRequest.getNewProductAmount()*stockInRequest.getNewUnitRate());
            stockInEntity.setTotalProductPrice(totalProductPrice);
            stockInEntity.setNewProductAmount(stockInRequest.getNewProductAmount());
            stockInEntity.setNewUnitRate(stockInRequest.getNewUnitRate());
        }

        stockInEntity.setUnitSellingPrice(stockInRequest.getUnitSellingPrice());
        stockInEntity.setProductDescription(stockInRequest.getProductDescription());
        stockInEntity.setShopProductAmount(stockInRequest.getShopProductAmount());
        stockInEntity.setShopShelfNo(stockInRequest.getShopShelfNo());
        stockInEntity.setShopShelfLevelNo(stockInRequest.getShopShelfLevelNo());
        stockInEntity.setWearHouseProductAmount(stockInRequest.getWearHouseProductAmount());
        stockInEntity.setWearHouseShelfNo(stockInRequest.getWearHouseShelfNo());
        stockInEntity.setWearHouseShelfLevelNo(stockInRequest.getWearHouseShelfLevelNo());
        stockInEntity.setUpdateStockInDate(stockInRequest.getUpdateStockInDate());




        return stockInEntity;

    }
}
