package com.example.Aesthetic.service;

import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void add(ProductRequestDto productRequestDto,MultipartFile file);
    public void update(ProductRequestDto productRequestDto, Long id, MultipartFile file);
    public void delete(Long id);
    public List<ProductResponseDto> findAll();
    public ProductResponseDto findById(Long id);
    public List<ProductResponseDto> findByCategory(String category);
    public List<ProductResponseDto> findBySubCategory(String SubCategory);
}

