package com.example.Aesthetic.dto.response;

import com.example.Aesthetic.model.subcategory.Subcategory;

import java.util.List;
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
   public Set<ProductInfo> getProducts();
   interface ProductInfo {
      public String getName();
      public String getDescription();
      public Double getPrice();
      public Double getDiscount();
      public Integer getQuantity();
      public String getBrand();
      public String getWeight();
      public String getDimensions();
   }
}
