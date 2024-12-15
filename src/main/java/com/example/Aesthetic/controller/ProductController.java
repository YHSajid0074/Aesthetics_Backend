package com.example.Aesthetic.controller;

import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import com.example.Aesthetic.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("create")
    public ResponseEntity<String>create(@RequestBody ProductRequestDto productRequestDto) {
        productService.add(productRequestDto);
        return ResponseEntity.ok("Product created");
    }

    @PutMapping("Update")
    public ResponseEntity<String>update(@RequestBody ProductRequestDto productRequestDto,@RequestParam Long id) {
        productService.update(productRequestDto,id);
        return ResponseEntity.ok("Product updated");
    }

    @DeleteMapping
    public ResponseEntity<String>delete(@RequestParam Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@RequestParam Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("category")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productService.findByCategory(category));
    }

    @GetMapping("subCategory")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsBySubCategory(@RequestParam String SubCategory) {
        return ResponseEntity.ok(productService.findBySubCategory(SubCategory));
    }
}
