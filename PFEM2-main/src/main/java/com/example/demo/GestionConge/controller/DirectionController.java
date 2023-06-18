package com.example.demo.GestionConge.controller;

import com.example.demo.GestionConge.model.dto.DirectionDto;
import com.example.demo.GestionConge.model.entity.Direction;
import com.example.demo.GestionConge.services.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="direcetions")
public class DirectionController {
   @Autowired
   private DirectionService directionService;

	@GetMapping("/getdirection")
	public DirectionDto getDirection(@RequestParam Long id) {

		return directionService.getPoste(id);
	}
	@PostMapping(value={"/postdirection"})
	public DirectionDto SavePoste( @RequestBody DirectionDto dirct) {
		return directionService.addPoste(dirct);
	}

	@PostMapping(value={"/updatedirection"})
	public DirectionDto updatePoste( @RequestBody DirectionDto dirct) {

		return directionService.updatePoste(dirct);
	}

	@GetMapping(value={"/deletedirection"})
	public void deletePoste(Long id) {

		directionService.deletePoste(id);
	}

	@GetMapping(value={"/getalldirection"})
	public List<Direction> getAllPoste( ) {
		return directionService.getAllPoste();
	}



}
