package com.example.ProdManagement.Service;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Model.Response.ResponseClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    ResponseEntity<ProductResponse> addingProduct(ProductRequest productRequest);

    List<ResponseClass> getAllProducts();
    Optional<ProductData> getProductById(Integer productCode);

    ResponseEntity<String> deleteProduct(Integer productCode);

    Optional<ProductData> updateProductData(ProductRequest productRequest, Integer productCode);

}