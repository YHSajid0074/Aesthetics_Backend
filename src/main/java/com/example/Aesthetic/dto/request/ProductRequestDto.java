package com.example.Aesthetic.dto.request;

public record ProductRequestDto (

       String name,
       String description,
       String category,
       String subcategory,
       Double price,
       Double discount,
       Integer quantity,
       String brand,
       String weight,
       String dimensions

){
}
