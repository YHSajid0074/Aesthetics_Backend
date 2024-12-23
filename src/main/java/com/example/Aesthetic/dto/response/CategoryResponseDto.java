package com.example.Aesthetic.dto.response;

import java.util.List;
import java.util.Set;

public interface CategoryResponseDto {

   String getName(); // Maps to c.name (alias: name)

   Background getBackground(); // Maps to b.url (alias: backgroundUrl)
   interface Background {
      String getBackgroundUrl(); // Maps to b.url
   }

   Set<Subcategory> getSubcategories(); // Maps to s.name (alias: subcategoryName)
   interface Subcategory {
      String getSubcategoryName(); // Maps to s.name
   }

   Set<Product> getProducts(); // Maps to product-related aliases
   interface Product {
      String getProductName(); // Maps to p.name
      String getProductDescription(); // Maps to p.description
      Double getProductPrice(); // Maps to p.price
      Double getProductDiscount(); // Maps to p.discount
      Integer getProductQuantity(); // Maps to p.quantity
      String getProductBrand(); // Maps to p.brand
      String getProductWeight(); // Maps to p.weight
      String getProductDimensions(); // Maps to p.dimensions
   }
}

