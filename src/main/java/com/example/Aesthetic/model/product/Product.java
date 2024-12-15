package com.example.Aesthetic.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private String category;
    private String subcategory;
    private Double price;
    private Double discount;
    private Integer quantity;
    private String brand;
    private String weight;
    private String dimensions;

    @ElementCollection
    private List<String> imageUrls;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
