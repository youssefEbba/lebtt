package com.example.demo.GestionConge.repository;

import com.example.demo.GestionConge.model.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Poste, Long> {


}