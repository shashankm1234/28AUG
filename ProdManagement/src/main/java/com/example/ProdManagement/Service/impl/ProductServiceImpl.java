package com.example.ProdManagement.Service.impl;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Data.Repository.ProductRepo;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Model.Response.ResponseClass;
import com.example.ProdManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<ProductResponse> addingProduct(ProductRequest productRequest) {
        ProductResponse productResponse=new ProductResponse();
        ProductData productData=new ProductData();
            productData.setProductName(productRequest.getProductName());
            productData.setProductDescription(productRequest.getProductDesc());
            productData.setProductType(productRequest.getProductType());
            productData.setIsActive(true);
            productData.setCreatedAt(new Date());
            productData.setModifiedAt(new Date());

            productRepo.save(productData);

            productResponse.setMessage("Product Created Successfully");
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @Override
    public List<ResponseClass> getAllProducts() {
        List<ProductData> allResponse = new ArrayList<>();
        List<ProductRepo> productRepos;
        for(ProductData productData : ProductRepo){
            ProductData productData1 = new ProductData();
            productData1(ProductRepo.getProductCode);
            allResponse.setProductName(ProductRepo.getProductName);
            allResponse.setProductType(ProductRepo.getProductType);
            allResponse.setProductDescription(ProductRepo.getProductDesc);
            productData1.add(productResponse);

            return productData1;
        }


//      return productRepo.findAll();
    }

    @Override
    public Optional<ProductData> getProductById(Integer productCode) {

        return productRepo.findById(productCode);
    }

//    public Optional<ProductData> getProductByName(String productName){
//        return productRepo.getProductByName(productName);
//    }
//
//    public Optional<ProductData> getProductByType(String productType){
//        return productRepo.getProductByType(productType);
//    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer productCode) {
        if(productRepo.existsById(productCode)) {
            productRepo.deleteById(productCode);
            return new ResponseEntity<String>("Product Deleted Successfully!",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Product Code Invalid",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Optional<ProductData> updateProductData(ProductRequest productRequest, Integer productCode) {
            Optional<ProductData> existingData = productRepo.findById(productCode);
            existingData.get().setProductName(productRequest.getProductName());
            existingData.get().setProductDescription(productRequest.getProductDesc());
            existingData.get().setProductType(productRequest.getProductType());
            productRepo.save(existingData.get());
            return existingData;
    }

}