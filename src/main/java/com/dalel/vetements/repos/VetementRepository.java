package com.dalel.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalel.vetements.entities.Vetement;

public interface VetementRepository extends JpaRepository<Vetement, Long> {

}
