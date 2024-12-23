package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.BackgroundRequestDto;
import com.example.Aesthetic.dto.response.BackgroundResponseDto;
import com.example.Aesthetic.model.background.Background;
import com.example.Aesthetic.repository.backgroundrepo.BackgroundRepo;
import com.example.Aesthetic.service.BackgroundService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BackgroundServiceImpl implements BackgroundService {

    public BackgroundRepo backgroundRepo;

    public BackgroundServiceImpl(BackgroundRepo backgroundRepo) {
        this.backgroundRepo = backgroundRepo;
    }

   public Background ConvertToEntity(BackgroundRequestDto backgroundRequestDto,Background background) {

        background.setName(backgroundRequestDto.name());
        background.setUrl(backgroundRequestDto.url());

        return background;
   }

    @Override
    public void createBackground(BackgroundRequestDto backgroundRequestDto) {

        Background background = ConvertToEntity(backgroundRequestDto,new Background());
        backgroundRepo.save(background);

    }

    @Override
    public Set<BackgroundResponseDto> getBackgrounds() {
        return backgroundRepo.findAllBy();
    }

    @Override
    public BackgroundResponseDto getBackground(Long id) {
        return backgroundRepo.findBackgroundById(id);
    }

    @Override
    public void updateBackground(BackgroundRequestDto backgroundRequestDto, Long id) {
        Background background=backgroundRepo.findById(id).get();
        Background updatedBackground=ConvertToEntity(backgroundRequestDto,background);
        backgroundRepo.save(updatedBackground);
    }

    @Override
    public void deleteBackground(Long id) {
       backgroundRepo.deleteById(id);
    }

    @Override
    public Set<BackgroundResponseDto> findByName(String name) {
        return backgroundRepo.findAllByName(name);
    }
}
