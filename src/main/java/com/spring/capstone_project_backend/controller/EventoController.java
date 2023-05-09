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
import org.springframework.web.bind.annotation.RestController;

import com.spring.capstone_project_backend.model.Evento;
import com.spring.capstone_project_backend.service.EventoService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/eventi")
public class EventoController {

	@Autowired EventoService service;

	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Evento>>(service.getAllEventi(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getEvento(id), HttpStatus.OK);
	}
	
	@GetMapping("/data/{data}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNumero(@PathVariable LocalDate data){
		return new ResponseEntity<List<Evento>>(service.getEventiPerDataEvento(data), HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("/listaeventi")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Evento>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Evento>>(service.getAllEventiPageable(pag), HttpStatus.OK);
	}
	
	@GetMapping("/partetitolo/{titoloEvento}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNomeParte(@PathVariable("nome") String nome){
		return new ResponseEntity<>(service.getAllEventiPerTitoloEvento(nome), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createCliente(@RequestBody Evento evento) {
		return new ResponseEntity<Evento>(service.createEvento(evento), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeEvento(id), HttpStatus.OK);
	}
	@PutMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Evento evento) {
		return new ResponseEntity<Evento>(service.updateEvento(evento), HttpStatus.CREATED);
	}
	
}
