package com.spring.capstone_project_backend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.spring.capstone_project_backend.model.ImageEntity;

public interface ImageRepository extends CrudRepository<ImageEntity, Long> {

	
	public boolean existsById(Long id);
	public boolean existsByFileName(String filename);
	
	
	public Optional<ImageEntity> findById(Long id);
	public Optional<ImageEntity> findByFileName(String filename);
	
	
}
