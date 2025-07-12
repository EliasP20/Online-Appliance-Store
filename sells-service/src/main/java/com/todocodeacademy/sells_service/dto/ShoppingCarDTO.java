package com.todocodeacademy.sells_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class ShoppingCarDTO {
    private Long carId;
    private List<Long> productsCodes;
    private Double totalPrice;
}
