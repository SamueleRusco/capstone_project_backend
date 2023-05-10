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
import com.spring.capstone_project_backend.model.UserNewsLetter;

@Configuration
public class UserNewsLetterConfiguration implements WebMvcConfigurer {
	
	@Bean("UserNewsLetterRandom")
	@Scope("prototype")
	public UserNewsLetter UserNewsLetterRandom() {
		Faker fake = new Faker(new Locale("it-IT"));		   
		
	    UserNewsLetter u = new UserNewsLetter();
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setEmail(u.getNome()+"."+u.getCognome()+"@gmail.com");
				
		return u;
		
	}
	
	
	
	

	
	
}
