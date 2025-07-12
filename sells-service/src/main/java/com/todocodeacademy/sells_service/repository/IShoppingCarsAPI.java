package com.todocodeacademy.sells_service.repository;

import com.todocodeacademy.sells_service.dto.ProductDTO;
import com.todocodeacademy.sells_service.dto.ShoppingCarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway")
public interface IShoppingCarsAPI {
    @GetMapping("/shopping-cars-service/{carId}")
    ShoppingCarDTO getShoppingCar(@PathVariable("carId") Long carId);

    @GetMapping("/shopping-cars-service/{carId}/products/car-products")
    ProductDTO getProductsFromShoppingCar(@PathVariable("carId") Long carId);
}
