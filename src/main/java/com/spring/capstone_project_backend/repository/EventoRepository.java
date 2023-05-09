package com.spring.capstone_project_backend.repository;

import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.capstone_project_backend.model.Evento;





public interface EventoRepository extends CrudRepository<Evento, Long>, PagingAndSortingRepository<Evento, Long> {
	
	public boolean existsByTitoloEvento(String titoloEvento);
	public boolean existsByLuogo(String luogo);
	public boolean existsByDataEvento(LocalDate dataEvento);
	
	public Evento FindByTitoloEvento(String titoloEvento);
	public Evento FindByLuogo(String luogo);
	public Evento FindByDataEvento(LocalDate dataEvento);

	
	
	
}
