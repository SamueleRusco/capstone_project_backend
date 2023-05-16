package com.spring.capstone_project_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.spring.capstone_project_backend.repository.ImageRepository;
import com.spring.capstone_project_backend.model.ImageEntity;


import java.io.IOException;
 
@RestController
@RequestMapping("/api/images")
public class ImageController {
 
    @Autowired
    private ImageRepository imageRepository;
    @CrossOrigin
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            byte[] imageData = file.getBytes();
 
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setFileName(fileName);
            imageEntity.setImageData(imageData);
            imageRepository.save(imageEntity);
 
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
}
