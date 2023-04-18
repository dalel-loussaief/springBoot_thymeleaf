package com.dalel.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dalel.vetements.entities.Vetement;

public interface VetementService {
	Vetement saveVetement(Vetement v);
	Vetement updateVetement(Vetement v);
	void deleteVetement(Vetement v);
	void deleteVetementById(Long id);
	Vetement getVetement(Long id);
	List<Vetement> getAllVetement();
	
	Page<Vetement> getAllVetementParPage(int page, int size);

	
	
}
