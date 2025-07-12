package com.todocodeAcademy.products_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;

    @NotBlank(message = "Product Name is required and must be a String")
    private String productName;

    @NotBlank(message = "Product brand is required and must be a String")
    private String productBrand;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be Positive")
    private Double productPrice;
}
