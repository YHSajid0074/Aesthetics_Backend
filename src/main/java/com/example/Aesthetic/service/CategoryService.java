package com.example.Aesthetic.service;

import com.example.Aesthetic.dto.request.CategoryRequestDto;
import com.example.Aesthetic.dto.response.CategoryResponseDto;
import com.example.Aesthetic.model.category.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Set<CategoryResponseDto> getAllCategories();

  Set<CategoryResponseDto> getCategoryById(Long id);

    void saveCategory(CategoryRequestDto categoryRequestDto);

    void updateCategory(CategoryRequestDto categoryRequestDto,Long id);

    void deleteCategory(Long id);
    public void addCategoryToSubcategory(Long id, Long SubcategoryId);
    public void addProductsById(Long categoryId, Set<Long> productIds);
    public void addBackground(Long categoryId, Long backgroundId);
}
