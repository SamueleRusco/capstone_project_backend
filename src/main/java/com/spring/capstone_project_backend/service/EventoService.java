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
import com.spring.capstone_project_backend.repository.EventoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EventoService {

	@Autowired EventoRepository repo;
	/*@Autowired @Qualifier("ClienteRandom") private ObjectProvider <Cliente> randomClienteProvider;*/
	
	@Autowired @Qualifier("EventoRandom") private ObjectProvider <Evento> randomEventoProvider;
	
	
	// Per creare cliente
	
	public void createEventoRandom() {		
		 createEvento(randomEventoProvider.getObject());
		}
	
	//Metodi per API
	
	public List<Evento> getAllEventi() {
		return (List<Evento>) repo.findAll();
	}
	
	public Page<Evento> getAllEventiPageable(Pageable pageable) {
		return (Page<Evento>) repo.findAll(pageable);
	}
	
	// get eventi
	public List <Evento> getEventiPerLuogo(String luogo) {
		if(!repo.existsByLuogo(luogo)) {
			throw new EntityNotFoundException("Non esistono eventi nel luogo indicato!");
		}
		return (List<Evento>) repo.findByLuogo(luogo);
	}
	
	public List <Evento> getEventiPerDataEvento(LocalDate dataEvento) {
		if(!repo.existsByDataEvento(dataEvento)) {
			throw new EntityNotFoundException("Non esistono eventi con la data indicata!");
		}
		return (List<Evento>) repo.findByDataEvento(dataEvento);
	}
	
	public List <Evento> getAllEventiPerTitoloEvento(String titolo) {
		if(!repo.existsByTitoloEvento(titolo)) {
			throw new EntityNotFoundException("Non esistono eventi con questo titolo!");
		}
		return (List<Evento>) repo.findByTitoloEvento(titolo);
	}
	
	public Evento getEvento(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Evento non esiste!!!");
		}
		return repo.findById(id).get();
	}	
	//create	
	public Evento createEvento(Evento evento) {
		if(repo.existsByTitoloEvento(evento.getTitoloEvento())) {
			throw new EntityExistsException("Evento esiste già!!!");
		} else {
			repo.save(evento);
		}		
		return evento;
	}
	
	public String removeEvento(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		repo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Evento updateEvento(Evento evento) {
		if(!repo.existsById(evento.getId())) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		repo.save(evento);
		return evento;
	}
	
	
		
}
