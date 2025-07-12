package com.todocodeAcademy.shopping_cars_service.controller;

import com.todocodeAcademy.shopping_cars_service.dto.ProductDTO;
import com.todocodeAcademy.shopping_cars_service.dto.ShoppingCarRequest;
import com.todocodeAcademy.shopping_cars_service.model.ShoppingCar;
import com.todocodeAcademy.shopping_cars_service.service.ShoppingCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-cars")
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;

    @PostMapping("")
    public ResponseEntity<?> createShoppingCar(@RequestBody ShoppingCarRequest shoppingCarRequest){
        ShoppingCar saved = shoppingCarService.createShoppingCar(shoppingCarRequest.getShoppingCar(), shoppingCarRequest.getProdNames());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getShoppingCar(@PathVariable Long carId){
        ShoppingCar car = shoppingCarService.getShoppingCar(carId);
        return ResponseEntity.ok(car);
    }

    @GetMapping()
    public ResponseEntity<?> getAllShoppingCars(){
        List<ShoppingCar> shoppingCars = shoppingCarService.getAllShoppingCars();
        return ResponseEntity.ok(shoppingCars);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<?> updateShoppingCar(@PathVariable Long carId, @RequestBody ShoppingCar newShoppingCar){
        ShoppingCar updated = shoppingCarService.updateShoppingCar(carId, newShoppingCar);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteShoppingCar(@PathVariable Long carId){
        shoppingCarService.deleteShoppingCar(carId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{carId}/products")
    public ResponseEntity<?> deleteProductsByName(@PathVariable Long carId, @RequestBody List<String> prodNames){
        ShoppingCar updated = shoppingCarService.removeProducts(carId, prodNames);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{carId}/products")
    public ResponseEntity<?> addProductsByName(@PathVariable Long carId, @RequestBody List<String> prodNames){
        ShoppingCar updated = shoppingCarService.addProducts(carId, prodNames);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{carId}/products/car-products")
    public ResponseEntity<?> getProductsFromCar(@PathVariable Long carId){
        List<ProductDTO> listOfProducts = shoppingCarService.getProductsFromCar(carId);

        return ResponseEntity.ok(listOfProducts);
    }
}
