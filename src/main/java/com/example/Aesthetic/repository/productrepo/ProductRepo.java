package com.example.Aesthetic.repository.productrepo;

import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("""
           SELECT p
            FROM Product p
            WHERE p.id = :id
           """)
   public  ProductResponseDto findProductById(Long id);

    @Query("""
            SELECT p
            FROM Product p
            """)
    public Set<ProductResponseDto> findAllProduct();

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.category = :category
      """)
    public Set<ProductResponseDto> findAllProductByCategory(String category);

    @Query("""
        SELECT p
        FROM Product p
        JOIN p.category c
        JOIN c.subcategories s
        WHERE s.name = :subcategory
""")
    public Set<ProductResponseDto> findAllProductBySubCategory(@Param("subcategory") String subcategory);;
    @Query("""
            SELECT p
            FROM Product p
            """)
  public Set<Product>findAllSet();
}

