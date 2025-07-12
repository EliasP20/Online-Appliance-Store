package com.todocodeAcademy.shopping_cars_service.dto;

import com.todocodeAcademy.shopping_cars_service.model.ShoppingCar;
import lombok.Data;

import java.util.List;

@Data
public class ShoppingCarRequest {
    private ShoppingCar shoppingCar;
    private List<String> prodNames;
}
