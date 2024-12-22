package com.example.Aesthetic.model.product;

import com.example.Aesthetic.model.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Double price;
    private Double discount;
    private Integer quantity;
    private String brand;
    private String weight;
    private String dimensions;

    private String imageName; // Image name
    private String imageType; // Image type (e.g., image/jpeg, image/png)

    @Lob
    @Column(length = 100000) // Adjust length based on your image size requirements
    private byte[] image;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
