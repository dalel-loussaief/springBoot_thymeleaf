package com.dalel.vetements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@SpringBootApplication
public class VetementsApplication implements CommandLineRunner{

	@Autowired
	VetementService vetementService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(VetementsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//vetementService.saveVetement(new Vetement("jupe","M",40.300,new Date()));
		//vetementService.saveVetement(new Vetement("pantallon","L",100.900,new Date()));
		//vetementService.saveVetement(new Vetement("robe noir","M",300.900,new Date()));
		
	}

}
