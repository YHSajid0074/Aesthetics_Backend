package com.example.Aesthetic.repository.categoryrepo;

import com.example.Aesthetic.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {


}
