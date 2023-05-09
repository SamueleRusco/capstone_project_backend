package com.spring.capstone_project_backend.model;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="eventi")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	private String luogo;
	
	@Column(nullable = false)
	private String titoloEvento;
	
	@Column(nullable = false)
	private String descrizione;
	
	
	
	@Column(nullable = false)
	private LocalDate dataEvento;
	

	
	@Column(nullable = false)
	private List<String> artistiEvento;
	
	@Lob
    @Column(nullable = true)
    private byte[] immagineEvento;
	

	
	
	
}
