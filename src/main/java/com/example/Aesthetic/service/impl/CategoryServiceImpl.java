package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.model.category.Category;
import com.example.Aesthetic.repository.categoryrepo.CategoryRepo;
import com.example.Aesthetic.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepo categoryRepo;
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category,Long id) {
        Category updatedCategory = categoryRepo.findById(id).get();
        updatedCategory.setName(category.getName());
        return categoryRepo.save(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
