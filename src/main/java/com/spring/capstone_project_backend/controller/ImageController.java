package com.spring.capstone_project_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.spring.capstone_project_backend.repository.ImageRepository;
import com.spring.capstone_project_backend.service.ImageService;
import com.spring.capstone_project_backend.model.Evento;
import com.spring.capstone_project_backend.model.ImageEntity;


import java.io.IOException;
import java.util.List;


 
@RestController
@RequestMapping("/api/images")
public class ImageController { 
	
    @Autowired
    private ImageRepository imageRepository;
    @Autowired ImageService service;
    
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
    
    @GetMapping("/listaimmagini")
    public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<ImageEntity>>(service.getAllImage(), HttpStatus.OK);
	}
	
	@GetMapping("/immagine/{id}")	
	
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getImage(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/immagine/{id}")
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
	    String result = service.removeImage(id);
	    

	    if (result.equals("immagine cancellata con successo")) {
	        return new ResponseEntity<>("Immagine cancellata con successo", HttpStatus.OK);
	    } else if (result.equals("l'immagine non esiste!!")) {
	        return new ResponseEntity<>("Impossibile trovare l'immagine specificata", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Errore durante l'eliminazione dell'immagine", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
