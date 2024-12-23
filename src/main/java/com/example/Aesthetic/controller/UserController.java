package com.example.Aesthetic.controller;


import com.example.Aesthetic.dto.request.UserRequestDto;
import com.example.Aesthetic.dto.response.UserResponseDto;
import com.example.Aesthetic.service.UserService;
import com.example.Aesthetic.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("user")
public class UserController {
   @Autowired
   EmailService emailService;
    UserService userService;

    public UserController(UserService userService, EmailService emailService) {
        this.emailService=emailService;
        this.userService = userService;
    }

    @PostMapping("createUser")
    public ResponseEntity<String>createUser(@RequestBody UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
        return ResponseEntity.ok("User Created");
    }

    @GetMapping("update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequestDto userRequestDto,@PathVariable Long id) {
        userService.update(userRequestDto, id);
        return ResponseEntity.ok("User Updated Successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<Set<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("username")
    public ResponseEntity<UserResponseDto> getUserByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

}
