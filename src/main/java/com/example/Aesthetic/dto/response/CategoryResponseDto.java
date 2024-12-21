package com.example.Aesthetic.dto.response;

import com.example.Aesthetic.model.subcategory.Subcategory;

import java.util.Set;

public interface CategoryResponseDto {

   public String getName();

   public Set<SubcategoryResponseDto> getSubcategory();

}
