package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.SubcategoryRequestDto;
import com.example.Aesthetic.dto.response.SubcategoryResponseDto;
import com.example.Aesthetic.model.subcategory.Subcategory;
import com.example.Aesthetic.repository.subcategoryrepo.SubcategoryRepo;
import com.example.Aesthetic.service.SubcategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    SubcategoryRepo subcategoryRepo;

    public SubcategoryServiceImpl(SubcategoryRepo subcategoryRepo) {
        this.subcategoryRepo = subcategoryRepo;
    }

    public Subcategory ConvertToEntity(SubcategoryRequestDto subcategoryRequestDto,Subcategory savedSubcategory) {
        savedSubcategory.setName(subcategoryRequestDto.name());
        return savedSubcategory;
    }

    @Override
    public Set<SubcategoryResponseDto> getAllSubcategoriesBy() {
        return subcategoryRepo.findAllSubcategories();
    }

    @Override
    public SubcategoryResponseDto getSubcategoryById(Long id) {
        return subcategoryRepo.findSubcategoriesById(id);
    }

    @Override
    public void addSubcategory(SubcategoryRequestDto subcategoryRequestDto) {
        Subcategory subcategory=ConvertToEntity(subcategoryRequestDto,new Subcategory());
        subcategoryRepo.save(subcategory);
    }

    @Override
    public void updateSubcategory(SubcategoryRequestDto subcategory, Long id) {
        Subcategory oldSubcategory = subcategoryRepo.findById(id).get();
        Subcategory newSubcategory = ConvertToEntity(subcategory, oldSubcategory);
        subcategoryRepo.save(newSubcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepo.deleteById(id);
    }
}
