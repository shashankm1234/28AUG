package com.example.ProdManagement.Controller;

import com.example.ProdManagement.Data.Entity.ProductData;
import com.example.ProdManagement.Model.Request.ProductRequest;
import com.example.ProdManagement.Model.Response.ProductResponse;
import com.example.ProdManagement.Model.Response.ResponseClass;
import com.example.ProdManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> creatingProduct(@RequestBody ProductRequest productRequest){
        return productService.addingProduct(productRequest);
    }

    @GetMapping("/api/products")
    public List<ResponseClass> gettingAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public Optional<ProductData> gettingProductById(@PathVariable("id") Integer productCode){
        return productService.getProductById(productCode);
    }

//    @GetMapping("/api/products/{productName}")
//    public Optional<ProductData> gettingProductByName(@PathVariable("name") String productName){
//        return productService.
//    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<String> deletingProduct(@PathVariable("id") Integer productCode){
        return productService.deleteProduct(productCode);
    }

    @PutMapping("/api/products/{id}")
    public Optional<ProductData> updatingProduct(@PathVariable("id") Integer productCode, @RequestBody ProductRequest productRequest){
        return productService.updateProductData(productRequest,productCode);
    }
}