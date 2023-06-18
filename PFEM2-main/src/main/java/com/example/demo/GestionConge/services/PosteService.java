
package com.example.demo.GestionConge.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.GestionConge.model.dto.posteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.GestionConge.model.entity.Poste;
import com.example.demo.GestionConge.repository.PostRepo;

@Service
public class PosteService {
	@Autowired
	private PostRepo posteRepo ;


	public posteDto getPoste(Long id) {

		Optional<Poste> pos =this.posteRepo.findById(id);
		if(pos.isPresent())
			return posteDto.toDto(pos.get());
		else
			return  null;
	}

	public posteDto addPoste(posteDto pos) {

		return posteDto.toDto(posteRepo.save(Poste.toEntity(pos)))	;

	}

	public posteDto updatePoste(posteDto pos) {

			 return posteDto.toDto(posteRepo.save(Poste.toEntity(pos)));

	}
	public  void deletePoste(Long id) {

		 this.posteRepo.deleteById(id);
	}

	public List<Poste> getAllPoste() {

		return posteRepo.findAll();
	}


}
