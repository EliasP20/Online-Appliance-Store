package com.todocodeAcademy.shopping_cars_service.repository;

import com.todocodeAcademy.shopping_cars_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway")
public interface IProductsAPI {
    @GetMapping("/products-service/products/search/by-name/{prodName}")
    ProductDTO getProductByName(@PathVariable("prodName") String prodName);

    @GetMapping("products-service/products/{productCode}")
    ProductDTO getProductByCode(@PathVariable("productCode") Long productCode);
}
