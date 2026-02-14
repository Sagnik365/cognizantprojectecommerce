package com.cognizant.ecommerce.dtos;

import lombok.Data;

@Data
public class ItemRequestDTO {
    private String name;
    private String description;
    private String category;
}
