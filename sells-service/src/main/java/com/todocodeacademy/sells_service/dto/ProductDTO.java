package com.todocodeacademy.sells_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductDTO {
    private Long productCode;
    private String productName;
    private Double productPrice;
}
