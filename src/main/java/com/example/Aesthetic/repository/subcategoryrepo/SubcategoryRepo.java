package com.example.Aesthetic.repository.subcategoryrepo;

import com.example.Aesthetic.dto.response.SubcategoryResponseDto;
import com.example.Aesthetic.model.subcategory.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {

    @Query("""
            Select s from Subcategory s
            WHERE s.id =:id
            """)
    public SubcategoryResponseDto findSubcategoriesById(Long id);

    @Query("""
            Select s 
            from Subcategory s
            """)

    public Set<SubcategoryResponseDto> findAllSubcategories();
}
