package com.spring.capstone_project_backend.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import com.spring.capstone_project_backend.service.EventoService;

@Component
public class CapstoneBeRunner implements ApplicationRunner{
	@Autowired EventoService eventoService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Runner ok");
	starterDB();
	}
private void starterDB(){
	for (int i = 0; i<10; i++) {
		eventoService.createEventoRandom();
	}
}
}
