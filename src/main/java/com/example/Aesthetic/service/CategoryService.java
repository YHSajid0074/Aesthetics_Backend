package com.example.Aesthetic.service;

import com.example.Aesthetic.model.category.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategory(Category category,Long id);

    void deleteCategory(Long id);
}
