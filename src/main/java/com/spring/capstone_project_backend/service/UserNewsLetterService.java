package com.spring.capstone_project_backend.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import com.spring.capstone_project_backend.model.UserNewsLetter;
import com.spring.capstone_project_backend.repository.UserNewsLetterRepository;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class UserNewsLetterService {

	@Autowired UserNewsLetterRepository repo;
	
	
	@Autowired @Qualifier("UserNewsLetterRandom") private ObjectProvider <UserNewsLetter> randomUserNewsLetterProvider;
	
	
	// Per creare evento
	
	
	
	//Metodi per API
	
	public List<UserNewsLetter> getAllUserNewsLetter() {
		return (List<UserNewsLetter>) repo.findAll();
	}
	
	public Page<UserNewsLetter> getAllUserNewsLetterPageable(Pageable pageable) {
		return (Page<UserNewsLetter>) repo.findAll(pageable);
	}
	
	// get eventi
	/*public List <UserNewsLetter> getEventiPerLuogo(String luogo) {
		if(!repo.existsByLuogo(luogo)) {
			throw new EntityNotFoundException("Non esistono eventi nel luogo indicato!");
		}
		return (List<Evento>) repo.findByLuogo(luogo);
	}*/
	
	/*public List <Evento> getEventiPerDataEvento(LocalDate dataEvento) {
		if(!repo.existsByDataEvento(dataEvento)) {
			throw new EntityNotFoundException("Non esistono eventi con la data indicata!");
		}
		return (List<Evento>) repo.findByDataEvento(dataEvento);
	}*/
	
	public List <UserNewsLetter> getAllUserNewsLetterPerNome(String nome) {
		if(!repo.existsByNome(nome)) {
			throw new EntityNotFoundException("Non esistono eventi con questo titolo!");
		}
		return (List<UserNewsLetter>) repo.findByNome(nome);
	}
	
	public UserNewsLetter getUserNewsLetter(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("User non esiste!!!");
		}
		return repo.findById(id).get();
	}	
	//create
	
	public void createUserNewsLetterRandom() {		
		 createUserNewsLetter(randomUserNewsLetterProvider.getObject());
		}
	
	public UserNewsLetter createUserNewsLetter(UserNewsLetter u) {
		if(u.getId()!= null && repo.existsById(u.getId())) {
			throw new EntityExistsException("User esiste già!!!");
		} else {
			repo.save(u);
		}		
		return u;
	}
	
	public String removeEvento(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("User non esiste!!");
		}
		repo.deleteById(id);
		return "evento non esiste!!!";
	}
	
	public UserNewsLetter updateEvento(UserNewsLetter u) {
		if(!repo.existsById(u.getId())) {
			throw new EntityExistsException("User non esiste!!!");
		}
		repo.save(u);
		return u;
	}
	
	
	
		
}
