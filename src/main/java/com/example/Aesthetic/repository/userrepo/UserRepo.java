package com.example.Aesthetic.repository.userrepo;


import com.example.Aesthetic.dto.response.UserResponseDto;
import com.example.Aesthetic.model.user.CUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<CUser, Long> {

    @Query("""
           SELECT u 
           FROM CUser u 
           WHERE u.id = :id
            """)
    public UserResponseDto findByUserId(Long id);

    @Query("""
            SELECT u
            FROM CUser u
            WHERE u.username = :username
            """)
    public UserResponseDto findByUsername(String username);

    @Query(
            """
             SELECT u
             from CUser u   
                    """
    )

    public Set<UserResponseDto> findAllbY();
}
