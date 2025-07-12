package com.todocodeAcademy.shopping_cars_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ShoppingCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> productsCodes;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be Positive")
    private Double totalPrice;
}
