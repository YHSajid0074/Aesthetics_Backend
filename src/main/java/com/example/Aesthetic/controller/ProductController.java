package com.example.Aesthetic.controller;

import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import com.example.Aesthetic.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("Product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/add1")
    public ResponseEntity<String> addProduct1(
            @RequestParam("image") MultipartFile image  // Handle image as MultipartFile
            ) { // Handle product details as request body

        return ResponseEntity.ok("Product added successfully!");
    }

    //    @PostMapping("create")
//    public ResponseEntity<String>create(@RequestBody ProductRequestDto productRequestDto,@RequestPart MultipartFile file) {
//        productService.add(productRequestDto,file);
//        return ResponseEntity.ok("Product created");
//    }
    @PostMapping(value="/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> addProduct(
            // Handle image as MultipartFile
            @ModelAttribute ProductRequestDto productRequestDto) { // Handle product details as request body
        productService.add(productRequestDto, productRequestDto.file());
        return ResponseEntity.ok("Product added successfully!");
    }


    @PutMapping("Update")
    public ResponseEntity<String> update(@RequestPart ProductRequestDto productRequestDto, @RequestParam Long id, @RequestPart MultipartFile file) {
        productService.update(productRequestDto, id, file);
        return ResponseEntity.ok("Product updated");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }

//    @GetMapping("{id}")
//    public ResponseEntity<ProductResponseDto> getProductById(@RequestParam Long id) {
//        return ResponseEntity.ok(productService.findById(id));
//    }

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

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        try {
            // Call the service method to get product details
            ProductResponseDto productResponseDto = productService.findById(id);

            // Return the response with 200 OK and the product data
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            // If product not found, return 404 Not Found
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
