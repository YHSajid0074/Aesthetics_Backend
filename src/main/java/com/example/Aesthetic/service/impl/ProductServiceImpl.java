package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import com.example.Aesthetic.repository.productrepo.ProductRepo;
import com.example.Aesthetic.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product ConvertToEntity(ProductRequestDto productRequestDto, Product product) {

        product.setBrand(productRequestDto.brand());
        product.setName(productRequestDto.name());
        product.setPrice(productRequestDto.price());
        product.setDescription(productRequestDto.description());
        product.setCategory(productRequestDto.category());
        product.setDiscount(productRequestDto.discount());
        product.setQuantity(productRequestDto.quantity());
        product.setDescription(productRequestDto.description());
        product.setSubcategory(productRequestDto.category());
        product.setDimensions(productRequestDto.dimensions());

        return product;

    }

    @Override
    public void add(ProductRequestDto productRequestDto) {
        Product product = ConvertToEntity(productRequestDto, new Product());
        productRepo.save(product);
    }

    @Override
    public void update(ProductRequestDto productRequestDto,Long id ) {
        Product product = productRepo.findById(id).get();
        Product updatedProduct = ConvertToEntity(productRequestDto, product);
        productRepo.save(updatedProduct);
    }

    @Override
    public void delete(Long id ) {
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productRepo.findAllProduct();
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return productRepo.findProductById(id);
    }

    @Override
    public List<ProductResponseDto> findByCategory(String category) {
        return productRepo.findAllProductByCategory(category);
    }
    @Override
    public List<ProductResponseDto> findBySubCategory(String subcategory) {
        return productRepo.findAllProductBySubCategory(subcategory);
    }
}
