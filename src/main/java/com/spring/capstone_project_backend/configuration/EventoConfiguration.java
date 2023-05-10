package com.spring.capstone_project_backend.configuration;


import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.ECliente;*/
import com.github.javafaker.Faker; //importare java faker(???)
import com.spring.capstone_project_backend.model.Evento;

@Configuration
public class EventoConfiguration implements WebMvcConfigurer {
	
	@Bean("EventoRandom")
	@Scope("prototype")
	public Evento eventoRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		List<String> listaEventi = new ArrayList<>();	
		
		for(int i = 0; i < 3; i++) {	
		listaEventi.add(fake.artist().name());	
		}		
		
		long minDay = LocalDate.of(2023, 6, 1).toEpochDay();
	    long maxDay = LocalDate.of(2026, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);	    
		
		Evento e = new Evento();
		e.setLuogo(fake.address().city());
		e.setTitoloEvento(e.getLuogo() + "MUSIC FEST!");
		e.setDescrizione(fake.lorem().paragraph());
		e.setDataEvento(randomDate);
		e.setImmagineEvento("qui ci sarà un url che arriverà dalle api di imgur, studiati quelle api");
		e.setArtistiEvento(listaEventi);
		
		return e;
		
	}
	
	
	
	

	
	
}
