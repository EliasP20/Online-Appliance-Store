package com.todocodeAcademy.shopping_cars_service.repository;

import com.todocodeAcademy.shopping_cars_service.model.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCarRepository extends JpaRepository<ShoppingCar, Long> {
    
}
