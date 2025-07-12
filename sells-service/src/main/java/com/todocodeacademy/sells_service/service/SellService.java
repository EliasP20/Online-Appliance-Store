package com.todocodeacademy.sells_service.service;

import com.todocodeacademy.sells_service.dto.ShoppingCarDTO;
import com.todocodeacademy.sells_service.model.Sell;
import com.todocodeacademy.sells_service.repository.ISellRepository;
import com.todocodeacademy.sells_service.repository.IShoppingCarsAPI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SellService implements ISellService{
    @Autowired
    private IShoppingCarsAPI shoppingCarsAPI;

    @Autowired
    private ISellRepository sellRepository;


    @Override
    public Sell createSell(Long carId) {
        ShoppingCarDTO car = shoppingCarsAPI.getShoppingCar(carId);
        Sell sell = new Sell(null, LocalDateTime.now(), car.getCarId(), car.getTotalPrice());
        return sellRepository.save(sell);
    }

    @Override
    public Sell getSell(Long sellId) {
        return sellRepository.findById(sellId).orElseThrow(() -> new EntityNotFoundException("Sell with Id: " + sellId + " not found"));
    }

    @Override
    public Sell updateSell(Long sellId, Sell newSell) {
        Sell original = getSell(sellId);

        original.setShoppingCarId(newSell.getShoppingCarId());
        original.setSellDate(newSell.getSellDate());
        return createSell(original.getShoppingCarId());
    }

    @Override
    public void deleteSell(Long sellId) {
        getSell(sellId);
        sellRepository.deleteById(sellId);
    }

    @Override
    public List<Sell> getAllSells() {
        return sellRepository.findAll();
    }
}
