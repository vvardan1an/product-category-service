package com.example.restexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String title;
    private String authorName;
    private double price;
    private BookLanguage language;

}
