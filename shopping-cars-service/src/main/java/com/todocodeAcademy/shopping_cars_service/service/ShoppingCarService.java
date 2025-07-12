package com.todocodeAcademy.shopping_cars_service.service;

import com.netflix.discovery.converters.Auto;
import com.todocodeAcademy.shopping_cars_service.dto.ProductDTO;
import com.todocodeAcademy.shopping_cars_service.exception.ExternalServiceUnavailableException;
import com.todocodeAcademy.shopping_cars_service.model.ShoppingCar;
import com.todocodeAcademy.shopping_cars_service.repository.IProductsAPI;
import com.todocodeAcademy.shopping_cars_service.repository.IShoppingCarRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCarService implements IShoppingCarService{
    @Autowired
    IShoppingCarRepository shoppingCarRepository;

    @Autowired
    IProductsAPI productsAPI;

    @Override
    @CircuitBreaker(name = "products-service", fallbackMethod = "fallbackCreateShoppingCar")
    @Retry(name = "products-service")
    public ShoppingCar createShoppingCar(ShoppingCar shoppingCar, List<String> prodNames) {
        List<Long> productsCodes = new ArrayList<>();
        Double total = 0.0;
        for(String name: prodNames){
            ProductDTO product = productsAPI.getProductByName(name);
            productsCodes.add(product.getProductCode());
            total += product.getProductPrice();
        }

        shoppingCar.setProductsCodes(productsCodes);
        shoppingCar.setTotalPrice(total);
        return shoppingCarRepository.save(shoppingCar);
    }

    @Override
    public ShoppingCar getShoppingCar(Long carId) {
        return shoppingCarRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Shopping Car with id: " + carId + " not found"));
    }

    @Override
    public ShoppingCar updateShoppingCar(Long carId, ShoppingCar newShoppingCar) {
        ShoppingCar newCar = getShoppingCar(carId);
        newCar.setProductsCodes(newShoppingCar.getProductsCodes());
        newCar.setTotalPrice(newShoppingCar.getTotalPrice());

        return shoppingCarRepository.save(newCar);
    }

    @Override
    public void deleteShoppingCar(Long carId) {
        shoppingCarRepository.deleteById(carId);
    }

    @Override
    public List<ShoppingCar> getAllShoppingCars() {
        return shoppingCarRepository.findAll();
    }

    @Override
    @CircuitBreaker(name="products-service", fallbackMethod = "fallbackAddProducts")
    @Retry(name = "products-service")
    public ShoppingCar addProducts(Long carId, List<String> prodNames) {
        if (prodNames == null || prodNames.isEmpty()) {
            throw new IllegalArgumentException("No product names provided to add.");
        }
        ShoppingCar car = getShoppingCar(carId);
        for(String name: prodNames){
            ProductDTO prod = productsAPI.getProductByName(name);
            car.getProductsCodes().add(prod.getProductCode());
            car.setTotalPrice(car.getTotalPrice() + prod.getProductPrice());
        }
        return shoppingCarRepository.save(car);
    }

    @Override
    public ShoppingCar removeProducts(Long carId, List<String> prodNames) {
        if (prodNames == null || prodNames.isEmpty()) {
            throw new IllegalArgumentException("No product names provided to remove.");
        }
        ShoppingCar car = getShoppingCar(carId);
        for(String name: prodNames){
            ProductDTO prod = productsAPI.getProductByName(name);
            if(!car.getProductsCodes().contains(prod.getProductCode())){
                throw new IllegalArgumentException("Product: " + prod.getProductName() + " Not found in car");
            }
            car.getProductsCodes().remove(prod.getProductCode());
            car.setTotalPrice(car.getTotalPrice() - prod.getProductPrice());
        }
        return shoppingCarRepository.save(car);
    }

    public ShoppingCar fallbackCreateShoppingCar(ShoppingCar shoppingCar, List<String> prodNames, Throwable throwable){
        throw new ExternalServiceUnavailableException("Products service is currently unavailable. Please try again later");
    }

    public ShoppingCar fallbackAddProducts(Long carId, List<String> prodNames,Throwable throwable){
        throw new ExternalServiceUnavailableException("Products service is currently unavailable. Please try again later");
    }

    @Override
    public List<ProductDTO> getProductsFromCar(Long carId) {
        ShoppingCar car = this.getShoppingCar(carId);
        List<ProductDTO> productsOfCar = new ArrayList<>();

        for(Long prodCode: car.getProductsCodes()){
            productsOfCar.add(productsAPI.getProductByCode(prodCode));
        }
        return productsOfCar;
    }
}
