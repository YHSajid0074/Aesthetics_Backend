package com.example.Aesthetic.service;

import com.example.Aesthetic.dto.request.BackgroundRequestDto;
import com.example.Aesthetic.dto.response.BackgroundResponseDto;
import com.example.Aesthetic.model.background.Background;

import java.util.List;

public interface BackgroundService {
    public void createBackground(BackgroundRequestDto backgroundRequestDto);
    public List<BackgroundResponseDto> getBackgrounds();
    public BackgroundResponseDto getBackground(Long id);
    public void updateBackground(BackgroundRequestDto backgroundRequestDto, Long id);
    public void deleteBackground(Long id);
    public List<BackgroundResponseDto> findByName(String name);
}
