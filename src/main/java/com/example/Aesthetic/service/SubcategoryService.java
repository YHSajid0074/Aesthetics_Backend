package com.example.Aesthetic.service;

import com.example.Aesthetic.model.subcategory.Subcategory;

import java.util.List;

public interface SubcategoryService {

    public List<Subcategory> getAllSubcategories();

    public Subcategory getSubcategoryById(Long id);

    public void addSubcategory(Subcategory subcategory);

    public void updateSubcategory(Subcategory subcategory,Long Id);

    public void deleteSubcategory(Long id);
}
