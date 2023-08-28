package com.example.ProdManagement.Data.Repository;

import com.example.ProdManagement.Data.Entity.ProductData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductData,Integer> {

//    @Query("SELECT * FROM ProductData ORDER BY name")
//    Optional<ProductData> getProductByName(String productName);

//    @Query("SELECT * FROM ProductData ORDER BY type")
//    Optional<ProductData> getProductByType(String productType);
}