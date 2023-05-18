package com.spring.capstone_project_backend.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Data;





@Data
@Entity

public class ImageEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String fileName;
   
   
 
    @Lob
    private byte[] imageData;
 
    // Add other attributes as needed
 
    // Constructors, getters, and setters
 
 
}
