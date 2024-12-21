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
            Select c 
            from Category c
            """)

    public Set<CategoryResponseDto> findAllCategory();


}
