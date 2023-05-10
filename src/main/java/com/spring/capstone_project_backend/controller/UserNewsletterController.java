package com.spring.capstone_project_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.capstone_project_backend.model.UserNewsLetter;
import com.spring.capstone_project_backend.service.UserNewsLetterService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/newsletter")
public class UserNewsletterController {

	@Autowired UserNewsLetterService service;

	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<UserNewsLetter>>(service.getAllUserNewsLetter(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getUserNewsLetter(id), HttpStatus.OK);
	}
	
	@GetMapping("/user/{nome}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getUserNewsLetterPerNome(@PathVariable String nome){
		return new ResponseEntity<List<UserNewsLetter>>(service.getAllUserNewsLetterPerNome(nome), HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("/listauser")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Page<UserNewsLetter>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<UserNewsLetter>>(service.getAllUserNewsLetterPageable(pag), HttpStatus.OK);
	}
	
	@GetMapping("/partenome/{nome}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getUserNewsLetterParte(@PathVariable("nome") String nome){
		return new ResponseEntity<>(service.getAllUserNewsLetterPerNome(nome), HttpStatus.OK);
	}
	 
	
	@PostMapping
	
	public ResponseEntity<?> createUserNewsLetter(@RequestBody UserNewsLetter u) {
		return new ResponseEntity<UserNewsLetter>(service.createUserNewsLetter(u), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthorized()")
	public ResponseEntity<String> deleteUserNewsLetter(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeEvento(id), HttpStatus.OK);
	}
	@PutMapping
	@PreAuthorize("isAuthorized()")
	public ResponseEntity<?> updateUserNewsLetter(@RequestBody UserNewsLetter u) {
		return new ResponseEntity<UserNewsLetter>(service.updateEvento(u), HttpStatus.CREATED);
	}
	
}
