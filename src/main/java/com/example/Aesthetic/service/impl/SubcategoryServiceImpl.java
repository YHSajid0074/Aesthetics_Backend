package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.model.subcategory.Subcategory;
import com.example.Aesthetic.repository.subcategoryrepo.SubcategoryRepo;
import com.example.Aesthetic.service.SubcategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    SubcategoryRepo subcategoryRepo;

    public SubcategoryServiceImpl(SubcategoryRepo subcategoryRepo) {
        this.subcategoryRepo = subcategoryRepo;
    }


    @Override
    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepo.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepo.findById(id).get();
    }

    @Override
    public void addSubcategory(Subcategory subcategory) {
        subcategoryRepo.save(subcategory);
    }

    @Override
    public void updateSubcategory(Subcategory subcategory, Long id) {
        Subcategory oldSubcategory = subcategoryRepo.findById(id).get();
        oldSubcategory.setName(subcategory.getName());
        subcategoryRepo.save(oldSubcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepo.deleteById(id);
    }
}
