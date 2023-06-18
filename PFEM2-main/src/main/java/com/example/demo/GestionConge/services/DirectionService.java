package com.example.demo.GestionConge.services;

import com.example.demo.GestionConge.model.dto.DirectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.GestionConge.model.entity.Direction;
import com.example.demo.GestionConge.repository.DirectionRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionService {

	@Autowired
	private DirectionRepo  directionRepo;

	public DirectionDto getPoste(Long id) {

		Optional<Direction> drct =this.directionRepo.findById(id);
		if(drct.isPresent())
			return DirectionDto.DtoDto(drct.get());
		else
			return  null;
	}

	public DirectionDto addPoste(DirectionDto dirct) {

		return DirectionDto.DtoDto(directionRepo.save(Direction.dDtotoEntity(dirct)))	;

	}

	public DirectionDto updatePoste(DirectionDto dirct) {

		return DirectionDto.DtoDto(directionRepo.save(Direction.dDtotoEntity(dirct)));

	}
	public  void deletePoste(Long id) {

		this.directionRepo.deleteById(id);
	}

	public List<Direction> getAllPoste() {

		return directionRepo.findAll();
	}
}
