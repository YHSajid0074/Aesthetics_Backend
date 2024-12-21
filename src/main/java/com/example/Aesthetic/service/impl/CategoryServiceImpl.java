package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.CategoryRequestDto;
import com.example.Aesthetic.dto.response.CategoryResponseDto;
import com.example.Aesthetic.model.category.Category;
import com.example.Aesthetic.model.subcategory.Subcategory;
import com.example.Aesthetic.repository.categoryrepo.CategoryRepo;
import com.example.Aesthetic.repository.subcategoryrepo.SubcategoryRepo;
import com.example.Aesthetic.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepo categoryRepo;
    public SubcategoryRepo subcategoryRepo;
    public CategoryServiceImpl(CategoryRepo categoryRepo,SubcategoryRepo subcategoryRepo) {
        this.categoryRepo = categoryRepo;
        this.subcategoryRepo = subcategoryRepo;
    }

    public Category ConverToEntity(CategoryRequestDto categoryRequestDto,Category category) {
        category.setName(categoryRequestDto.name());
        return category;
    }

    @Override
    public Set<CategoryResponseDto> getAllCategories() {
        return categoryRepo.findAllCategory();
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return categoryRepo.findCategoryById(id);
    }

    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        Category category = ConverToEntity(categoryRequestDto,new Category());
       categoryRepo.save(category);
    }

    @Override
    public void updateCategory(CategoryRequestDto categoryRequestDto,Long id) {
        Category updatedCategory = categoryRepo.findById(id).get();
        Category category1=ConverToEntity(categoryRequestDto,updatedCategory);
        categoryRepo.save(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    public void addSubcategoryById(Long categoryId, Long subcategoryId) {
        // Fetch the parent category
        Category parentCategory = categoryRepo.findById(categoryId).orElseThrow(() ->
                new RuntimeException("Parent category not found with id: " + categoryId));

        // Fetch the subcategory
        Subcategory subcategory = subcategoryRepo.findById(subcategoryId).orElseThrow(() ->
                new RuntimeException("Subcategory not found with id: " + subcategoryId));

        // Add the subcategory to the parent category
        parentCategory.getSubcategories().add(subcategory);

        // Save the updated parent category
        categoryRepo.save(parentCategory);
    }
}
