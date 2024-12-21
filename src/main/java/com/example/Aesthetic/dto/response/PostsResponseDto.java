package com.example.Aesthetic.dto.response;

public interface PostsResponseDto {

    String getTitle();

    String getContent();

    String getImageName(); // The name of the image file

    String getImageType(); // The type of the image file (e.g., image/jpeg)

    byte[] getImage(); // The binary data of the image
}

