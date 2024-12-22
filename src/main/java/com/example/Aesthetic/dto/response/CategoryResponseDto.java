package com.example.Aesthetic.dto.response;

import com.example.Aesthetic.model.subcategory.Subcategory;

import java.util.Set;

public interface CategoryResponseDto {

   public String getName();

   public Set<Subcategories> getSubcategories();
   interface Subcategories {
      public String getName();
   }

   public Backgrounds getBackground();
   interface Backgrounds {
      String getUrl();
   }
}
