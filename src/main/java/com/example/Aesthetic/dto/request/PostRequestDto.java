package com.example.Aesthetic.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record PostRequestDto (
         String title,
         String content,
         MultipartFile file
){

}
