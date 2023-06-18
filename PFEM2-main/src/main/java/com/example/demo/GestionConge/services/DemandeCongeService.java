package com.example.demo.GestionConge.services;

import com.example.demo.GestionConge.model.dto.DemandeCongeDto;
import com.example.demo.GestionConge.model.entity.DemandeConge;
import com.example.demo.GestionConge.model.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.GestionConge.repository.DemandeCongeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongeService {

	@Autowired
	private DemandeCongeRepo demandeCongeRepo;
	public DemandeCongeDto getDemande(Long id) {
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Employee emp  = (Employee) authentication.getPrincipal();
		Optional<DemandeConge> demande =this.demandeCongeRepo.findById(id);
		if(demande.isPresent())
			return DemandeCongeDto.DemandetoDto(demande.get());
		else
			return  null;
	}

	public DemandeCongeDto addDemande(DemandeCongeDto dmnd ) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Employee emp  = (Employee) authentication.getPrincipal();
	   dmnd.setEmployee(emp);
		return DemandeCongeDto.DemandetoDto(demandeCongeRepo.save(DemandeConge.demtoEntity(dmnd)))	;

	}

	public DemandeCongeDto updateDemande(DemandeCongeDto pos) {
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Employee emp  = (Employee) authentication.getPrincipal();
		return DemandeCongeDto.DemandetoDto(demandeCongeRepo.save(DemandeConge.demtoEntity(pos)));

	}
	public  void deleteDemande(Long id) {

		this.demandeCongeRepo.deleteById(id);
	}

	public List<DemandeConge> getAllDemande() {

		return demandeCongeRepo.findAll();
	}
}
