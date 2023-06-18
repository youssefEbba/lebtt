package com.example.demo.GestionConge.repository;

import com.example.demo.GestionConge.model.entity.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeCongeRepo extends JpaRepository<DemandeConge, Long> {

}
