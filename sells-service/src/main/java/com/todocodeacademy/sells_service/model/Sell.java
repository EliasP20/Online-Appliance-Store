package com.todocodeacademy.sells_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellId;

    private LocalDateTime sellDate;

    private Long shoppingCarId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be Positive")
    private Double totalPrice;
}
