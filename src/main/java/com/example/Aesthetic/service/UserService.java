package com.example.Aesthetic.service;


import com.example.Aesthetic.dto.request.UserRequestDto;
import com.example.Aesthetic.dto.response.UserResponseDto;

import java.util.List;
import java.util.Set;

public interface UserService {

    public void create(UserRequestDto userRequestDto);

    public void update(UserRequestDto userRequestDto, Long id);

    public void delete(Long id);

    public UserResponseDto getUserById(Long id);

    public UserResponseDto getUserByUsername(String username);

    public Set<UserResponseDto> getAllUsers();

}
