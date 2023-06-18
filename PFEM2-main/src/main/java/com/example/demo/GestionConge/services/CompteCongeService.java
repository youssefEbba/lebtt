package com.example.demo.GestionConge.services;

import com.example.demo.GestionConge.model.dto.CompteCongeDto;
import com.example.demo.GestionConge.model.entity.CompteConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.GestionConge.repository.CompteCongeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompteCongeService {

	@Autowired
	private CompteCongeRepo compteCongeRepo;


	public CompteCongeDto findByID(Long id) {

		Optional<CompteConge> compteConge =this.compteCongeRepo.findById(id);
		if(compteConge.isPresent())
			return CompteCongeDto.CtoDto(compteConge.get());
		else
			return  null;
	}

	public CompteCongeDto addCompteConge(CompteCongeDto compteCongeDto) {

		return CompteCongeDto.CtoDto(compteCongeRepo.save(CompteConge.CDtotoEntity(compteCongeDto)))	;

	}

	public CompteCongeDto updateCompteConge(CompteCongeDto compteCongeDto) {

		return CompteCongeDto.CtoDto(compteCongeRepo.save(CompteConge.CDtotoEntity(compteCongeDto)));

	}
	public  void deleteCompteConge(Long id) {

		this.compteCongeRepo.deleteById(id);
	}

	public List<CompteConge> getAllCompteConge() {

		return compteCongeRepo.findAll();
	}
}

