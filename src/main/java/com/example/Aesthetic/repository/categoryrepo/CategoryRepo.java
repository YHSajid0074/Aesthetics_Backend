package com.example.Aesthetic.repository.categoryrepo;

import com.example.Aesthetic.dto.response.CategoryResponseDto;
import com.example.Aesthetic.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("""
            Select c 
            from Category c 
            where  c.id=:id
            """)
    public CategoryResponseDto findCategoryById(Long id);

    @Query("""
    SELECT c.name AS name,
           b.url AS backgroundUrl,
           s.name AS subcategoryName,
           p.name AS productName,
           p.description AS productDescription,
           p.price AS productPrice,
           p.discount AS productDiscount,
           p.quantity AS productQuantity,
           p.brand AS productBrand,
           p.weight AS productWeight,
           p.dimensions AS productDimensions
    FROM Category c
    LEFT JOIN c.background b
    LEFT JOIN c.subcategories s
    LEFT JOIN c.products p
""")
    Set<CategoryResponseDto> findAllCategory();





}
