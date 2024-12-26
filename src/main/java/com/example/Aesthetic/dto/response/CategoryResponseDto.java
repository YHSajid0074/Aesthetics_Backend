package com.example.Aesthetic.dto.response;

import java.util.Set;

public interface CategoryResponseDto {

   String getName(); // Maps to c.name (alias: name)

   Background getBackground(); // Maps to b.url (alias: backgroundUrl)
   interface Background {
      String getUrl(); // Maps to b.url
   }

   Set<Subcategory> getSubcategories(); // Maps to s.name (alias: subcategoryName)
   interface Subcategory {
      public String getName(); // Maps to s.name
   }

   Set<Product> getProducts(); // Maps to product-related aliases
   interface Product {
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

