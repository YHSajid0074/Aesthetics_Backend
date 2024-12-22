package com.example.Aesthetic.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record ProductRequestDto (

       String name,
       String description,
       Double price,
       Double discount,
       Integer quantity,
       String brand,
       String weight,
       String dimensions,
       MultipartFile file

){
}
