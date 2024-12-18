package com.example.Aesthetic.controller;

import com.example.Aesthetic.dto.request.BackgroundRequestDto;
import com.example.Aesthetic.dto.response.BackgroundResponseDto;
import com.example.Aesthetic.model.background.Background;
import com.example.Aesthetic.service.BackgroundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("background")
public class BackgroundController {

    BackgroundService backgroundService;

    public BackgroundController(BackgroundService backgroundService) {
        this.backgroundService = backgroundService;
    }

    @GetMapping("all")
    public ResponseEntity<List<BackgroundResponseDto>> getAllBackgrounds() {
        return ResponseEntity.ok(backgroundService.getBackgrounds());
    }

    @GetMapping("{id}")
    public ResponseEntity<BackgroundResponseDto> getBackgroundById(@RequestParam Long id) {
        return ResponseEntity.ok(backgroundService.getBackground(id));
    }

    @PostMapping("Create")
    public ResponseEntity<String> createBackground(@RequestBody BackgroundRequestDto backgroundRequestDto) {
        backgroundService.createBackground(backgroundRequestDto);
        return ResponseEntity.ok("Background created");
    }

    @PutMapping("Update")
    public ResponseEntity<String>updateBackground(@RequestBody BackgroundRequestDto backgroundRequestDto,@RequestParam Long id) {
        backgroundService.updateBackground(backgroundRequestDto, id);
        return ResponseEntity.ok("Background updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBackground(Long id) {
        backgroundService.deleteBackground(id);
        return ResponseEntity.ok("Background deleted");
    }

    @GetMapping("find/{name}")
    public ResponseEntity<List<BackgroundResponseDto>>findByName(@RequestParam String name) {
        return ResponseEntity.ok(backgroundService.findByName(name));
    }
}
