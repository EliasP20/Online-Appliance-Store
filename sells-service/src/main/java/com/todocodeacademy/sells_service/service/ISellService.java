package com.todocodeacademy.sells_service.service;

import com.todocodeacademy.sells_service.model.Sell;

import java.util.List;

public interface ISellService {
    // Create a Sell
    Sell createSell(Long carId);

    //Read a Sell
    Sell getSell(Long sellId);

    //Update a Sell
    Sell updateSell(Long sellId, Sell newSell);

    //Delete a Sell
    void deleteSell(Long sellId);

    //Get all Sells
    List<Sell> getAllSells();
}
