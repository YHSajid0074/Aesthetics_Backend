package com.example.Aesthetic.controller;

import com.example.Aesthetic.dto.request.CategoryRequestDto;
import com.example.Aesthetic.dto.request.SubcategoryRequestDto;
import com.example.Aesthetic.dto.response.CategoryResponseDto;
import com.example.Aesthetic.dto.response.SubcategoryResponseDto;
import com.example.Aesthetic.service.CategoryService;
import com.example.Aesthetic.service.SubcategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Category")
public class CategorySectionController {

    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    public CategorySectionController(CategoryService categoryService, SubcategoryService subcategoryService) {
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.saveCategory(categoryRequestDto);
        return ResponseEntity.ok("Category created");
    }

    @PostMapping("subcategory/create")
    public ResponseEntity<String> createSubcategory(@RequestBody SubcategoryRequestDto subCategoryRequestDto) {
        subcategoryService.addSubcategory(subCategoryRequestDto);
        return ResponseEntity.ok("Subcategory created");
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("subcategory/{id}")
    public ResponseEntity<SubcategoryResponseDto> getSubcategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(subcategoryService.getSubcategoryById(id));
    }

    @GetMapping("All")
    public ResponseEntity<Set<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("subcategory/All")
    public ResponseEntity<Set<SubcategoryResponseDto>> getAllSubcategories() {
        return ResponseEntity.ok(subcategoryService.getAllSubcategoriesBy());
    }

    @PutMapping("updateCategory")
    public ResponseEntity<String> updateCategory(
            @RequestBody CategoryRequestDto categoryRequestDto, @RequestParam Long id) {
        categoryService.updateCategory(categoryRequestDto, id);
        return ResponseEntity.ok("Category updated");
    }

    @PutMapping("updateSubcategory")
    public ResponseEntity<String> updateSubcategory(
            @RequestBody SubcategoryRequestDto subCategoryRequestDto, @RequestParam Long id) {
        subcategoryService.updateSubcategory(subCategoryRequestDto, id);
        return ResponseEntity.ok("Subcategory updated");
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted");
    }

    @DeleteMapping("subcategory/delete")
    public ResponseEntity<String> deleteSubcategory(@RequestParam Long id) {
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.ok("Subcategory deleted");
    }

    @PostMapping("addSubcategory")
    public ResponseEntity<String> addSubcategory(
            @RequestParam Long categoryId, @RequestParam Long subCategoryId) {
        categoryService.addSubcategoryById(categoryId, subCategoryId);
        return ResponseEntity.ok("Subcategory added to category");
    }
}
