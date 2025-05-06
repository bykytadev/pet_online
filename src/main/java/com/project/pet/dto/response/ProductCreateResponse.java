package com.project.pet.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCreateResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private BigDecimal original_price;
    private String category;
}
