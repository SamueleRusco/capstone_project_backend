package com.spring.capstone_project_backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.capstone_project_backend.model.Evento;
import com.spring.capstone_project_backend.model.ImageEntity;
import com.spring.capstone_project_backend.repository.EventoRepository;
import com.spring.capstone_project_backend.repository.ImageRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ImageService {
	
	@Autowired ImageRepository repo;
	
	
	
	
	//Metodi per API
	
	public List<ImageEntity> getAllImage() {
		return (List<ImageEntity>) repo.findAll();
	}
	
	public Page<ImageEntity> getAllImagePageable(Pageable pageable) {
		return (Page<ImageEntity>) repo.findAll(pageable);
	}
	
	// get eventi
	public List <ImageEntity> getAllImageByFileName(String ImageEntity) {
		if(!repo.existsByFileName(ImageEntity)) {
			throw new EntityNotFoundException("Non esistono immagini con questo nome !");
		}
		return (List<ImageEntity>) repo.findByFileName(ImageEntity);
	}
	
	
	public ImageEntity getImage(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Evento non esiste!!!");
		}
		return repo.findById(id).get();
	}	
	//create	
	public ImageEntity createImage(ImageEntity ImageEntity) {
		if(repo.existsByFileName(ImageEntity.getFileName())) {
			throw new EntityExistsException("Evento esiste già!!!");
		} else {
			repo.save(ImageEntity);
		}		
		return ImageEntity;
	}
	
	public String removeImage(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("l'immagine non esiste!!");
		}
		repo.deleteById(id);
		return "immagine cancellata con successo";
	}
	
	public ImageEntity updateImage(ImageEntity ImageEntity) {
		if(!repo.existsById(ImageEntity.getId())) {
			throw new EntityExistsException("Evento non esiste!!!");
		}
		repo.save(ImageEntity);
		return ImageEntity;
	}

}
