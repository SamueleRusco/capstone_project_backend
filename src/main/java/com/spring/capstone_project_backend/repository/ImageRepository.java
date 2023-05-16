package com.spring.capstone_project_backend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.capstone_project_backend.model.Evento;
import com.spring.capstone_project_backend.model.ImageEntity;

public interface ImageRepository extends CrudRepository<ImageEntity, Long>, PagingAndSortingRepository<ImageEntity, Long> {
	
	
	public boolean existsByFileName(String fileName);	
	public boolean existsById(Long id);
	
	public ImageEntity findByFileName(String fileName);
	public Optional<ImageEntity> findById(Long id);


}
