package com.spring.capstone_project_backend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.spring.capstone_project_backend.model.UserNewsLetter;





public interface UserNewsLetterRepository extends CrudRepository<UserNewsLetter, Long>, PagingAndSortingRepository<UserNewsLetter, Long> {
	
	public boolean existsById(Long id);
	public boolean existsByNome(String nome);
	public boolean existsByEmail(String Email);
	
	public Optional<UserNewsLetter> findById(Long id);
	public UserNewsLetter findByNome(String nome);
	public UserNewsLetter findByEmail(String email);

	
	
	
}
