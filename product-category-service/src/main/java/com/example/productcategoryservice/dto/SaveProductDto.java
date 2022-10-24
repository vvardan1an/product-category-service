package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductDto {

    private String title;
    private int count;
    private double price;
    private Category category;
}
