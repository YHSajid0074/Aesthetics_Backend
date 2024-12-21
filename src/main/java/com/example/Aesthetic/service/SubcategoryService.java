package com.example.Aesthetic.service;

import com.example.Aesthetic.dto.request.SubcategoryRequestDto;
import com.example.Aesthetic.dto.response.SubcategoryResponseDto;
import com.example.Aesthetic.model.subcategory.Subcategory;

import java.util.List;
import java.util.Set;

public interface SubcategoryService {

    public Set<SubcategoryResponseDto> getAllSubcategoriesBy();

    public SubcategoryResponseDto getSubcategoryById(Long id);

    public void addSubcategory(SubcategoryRequestDto subcategory);

    public void updateSubcategory(SubcategoryRequestDto subcategory,Long Id);

    public void deleteSubcategory(Long id);
}
