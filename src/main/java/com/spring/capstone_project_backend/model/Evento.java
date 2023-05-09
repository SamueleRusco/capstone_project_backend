package com.spring.capstone_project_backend.model;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="eventi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titoloEvento;
	
	/*@Column(nullable = false)
	private String immagineEvento;*/ //da implementare sucessivamente
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private String luogo;
	
	@Column(nullable = false)
	private List<String> artistiEvento;//valutare inserimento degli hashtag(?)
	
	@Column(nullable = false)
	private LocalDate dataEvento;
	
	
	
}
