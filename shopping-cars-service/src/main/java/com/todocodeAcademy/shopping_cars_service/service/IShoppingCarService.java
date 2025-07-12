package com.todocodeAcademy.shopping_cars_service.service;

import com.todocodeAcademy.shopping_cars_service.dto.ProductDTO;
import com.todocodeAcademy.shopping_cars_service.model.ShoppingCar;

import java.util.List;

public interface IShoppingCarService {
    // Create a Shopping Car
    ShoppingCar createShoppingCar(ShoppingCar shoppingCar, List<String> prodNames);

    //Read a Shopping Car
    ShoppingCar getShoppingCar(Long carId);

    //Update a Shopping Car
    ShoppingCar updateShoppingCar(Long carId, ShoppingCar newShoppingCar);

    //Delete a Shopping Car
    void deleteShoppingCar(Long carId);

    //Get all Shopping Cars
    List<ShoppingCar> getAllShoppingCars();

    //Add products to Shopping Car
    ShoppingCar addProducts(Long carId, List<String> prodNames);

    //Remove products from Car
    ShoppingCar removeProducts(Long carId, List<String> prodName);

    List<ProductDTO> getProductsFromCar(Long carId);
}
