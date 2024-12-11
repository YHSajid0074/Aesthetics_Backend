package com.example.Aesthetic.service.impl;


import com.example.Aesthetic.dto.request.UserRequestDto;
import com.example.Aesthetic.dto.response.UserResponseDto;
import com.example.Aesthetic.model.user.CUser;
import com.example.Aesthetic.repository.userrepo.UserRepo;
import com.example.Aesthetic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public CUser ConvertToEntity(UserRequestDto userRequestDto, CUser cUser) {
        cUser.setUsername(userRequestDto.username());
        cUser.setPassword(userRequestDto.password());
        cUser.setPhone(userRequestDto.phone());
     return cUser;
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
        CUser user = ConvertToEntity(userRequestDto,new CUser());
        userRepo.save(user);
    }

    @Override
    public void update(UserRequestDto userRequestDto, Long id) {
       CUser user=userRepo.findById(id).get();
       CUser cUser =ConvertToEntity(userRequestDto,user);
       userRepo.save(cUser);
    }

    @Override
    public void delete(Long id) {
      userRepo.deleteById(id);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepo.findByUserId(id);
    }

    @Override
    public UserResponseDto getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAllbY();
    }
}
