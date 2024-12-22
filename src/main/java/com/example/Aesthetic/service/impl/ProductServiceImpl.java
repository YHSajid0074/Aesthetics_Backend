package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.response.CategoryResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.ProductResponseDto;
import com.example.Aesthetic.model.product.Product;
import com.example.Aesthetic.repository.productrepo.ProductRepo;
import com.example.Aesthetic.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product ConvertToEntity(ProductRequestDto productRequestDto, Product product,MultipartFile file) {

        product.setBrand(productRequestDto.brand());
        product.setName(productRequestDto.name());
        product.setPrice(productRequestDto.price());
        product.setDescription(productRequestDto.description());

        product.setDiscount(productRequestDto.discount());
        product.setQuantity(productRequestDto.quantity());
        product.setDimensions(productRequestDto.dimensions());
        product.setImageName(file.getOriginalFilename()); // Set original file name
        product.setImageType(file.getContentType()); // Set content type (e.g., image/jpeg)
        try {
            product.setImage(file.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error saving image file: " + e.getMessage());
        }



        return product;

    }

    @Transactional
    @Override
    public void add(ProductRequestDto productRequestDto,MultipartFile file) {
        Product product = ConvertToEntity(productRequestDto, new Product(),file);
        productRepo.save(product);
    }

    @Override
    public void update(ProductRequestDto productRequestDto,Long id,MultipartFile file ) {
        Product product = productRepo.findById(id).get();
        Product updatedProduct = ConvertToEntity(productRequestDto, product,file);
        productRepo.save(updatedProduct);
    }

    @Override
    public void delete(Long id ) {
        productRepo.deleteById(id);
    }


    @Override
    public List<ProductResponseDto> findAll() {
        List<Product> products = productRepo.findAll();

        // Transform each Product into a ProductResponseDto
        return products.stream()
                .map(product -> new ProductResponseDto() {
                    @Override
                    public String getName() {
                        return product.getName();
                    }

                    @Override
                    public String getBrand() {
                        return product.getBrand();
                    }

                    @Override
                    public String getWeight() {
                        return product.getWeight();
                    }

                    @Override
                    public String getDescription() {
                        return product.getDescription();
                    }


                    @Override
                    public Double getPrice() {
                        return product.getPrice();
                    }

                    @Override
                    public Double getDiscount() {
                        return product.getDiscount();
                    }

                    @Override
                    public Integer getQuantity() {
                        return product.getQuantity();
                    }

                    @Override
                    public String getDimensions() {
                        return product.getDimensions();
                    }

                    @Override
                    public byte[] getImageUrl() {
                        return product.getImage(); // Return the byte[] image directly
                    }

                    @Override
                    public List<CategoryResponseDto> getCategory() {
                        return List.of();
                    }


                })
                .collect(Collectors.toList());
    }


    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Return the ProductResponseDto that includes the byte[] image
        return new ProductResponseDto() {
            @Override
            public String getName() {
                return product.getName();
            }

            @Override
            public String getBrand() {
                return product.getBrand();
            }

            @Override
            public String getWeight() {
                return product.getWeight();
            }

            @Override
            public String getDescription() {
                return product.getDescription();
            }

            @Override
            public Double getPrice() {
                return product.getPrice();
            }

            @Override
            public Double getDiscount() {
                return product.getDiscount();
            }

            @Override
            public Integer getQuantity() {
                return product.getQuantity();
            }

            @Override
            public String getDimensions() {
                return product.getDimensions();
            }

            @Override

            public byte[] getImageUrl() {
                return product.getImage();  // Return the byte[] image directly
            }

            @Override
            public List<CategoryResponseDto> getCategory() {
                return List.of();
            }


        };
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
