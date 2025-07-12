package com.todocodeacademy.sells_service.controller;

import com.todocodeacademy.sells_service.model.Sell;
import com.todocodeacademy.sells_service.service.SellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sells")
public class SellController {
    @Autowired
    private SellService sellService;

    @PostMapping("/{carId}")
    public ResponseEntity<?> createSell(@PathVariable Long carId){
        Sell sell = sellService.createSell(carId);
        return ResponseEntity.status(HttpStatus.CREATED).body(sell);
    }

    @GetMapping("/{sellId}")
    public ResponseEntity<?> getSell(@PathVariable Long sellId){
        Sell sell = sellService.getSell(sellId);
        return ResponseEntity.ok(sell);
    }

    @PutMapping("/{sellId}")
    public ResponseEntity<?> updateSell(@Valid @PathVariable Long sellId, @RequestBody Sell modifiedSell){
        Sell updated = sellService.updateSell(sellId, modifiedSell);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{sellId}")
    public ResponseEntity<?> deleteSell(@Valid @PathVariable Long sellId){
        sellService.deleteSell(sellId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<?> getAllSells(){
        List<Sell> sells = sellService.getAllSells();
        return ResponseEntity.ok(sells);
    }
}
