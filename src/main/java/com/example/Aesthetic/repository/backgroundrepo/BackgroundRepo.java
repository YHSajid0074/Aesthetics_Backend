package com.example.Aesthetic.repository.backgroundrepo;

import com.example.Aesthetic.dto.response.BackgroundResponseDto;
import com.example.Aesthetic.model.background.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BackgroundRepo extends JpaRepository<Background, Long> {

    @Query("""
            SELECT b
            FROM Background b
            WHERE b.id = :id
            """)
    public BackgroundResponseDto findBackgroundById(Long id);

    @Query("""
              SELECT b
              FROM Background b
            """)
    public Set<BackgroundResponseDto> findAllBy();

    @Query("""
            SELECT b
            FROM Background b
            WHERE b.name LIKE %:name%
            """)
    public Set<BackgroundResponseDto> findAllByName(String name);
}
