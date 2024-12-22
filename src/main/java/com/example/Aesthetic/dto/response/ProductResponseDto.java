package com.example.Aesthetic.dto.response;

import java.util.List;

public interface ProductResponseDto {
    public String getName();
    public String getDescription();
    public Double getPrice();
    public Double getDiscount();
    public Integer getQuantity();
    public String getBrand();
    public String getWeight();
    public String getDimensions();
    public byte[] getImageUrl();

    public List<CategoryResponseDto>getCategory();
}
