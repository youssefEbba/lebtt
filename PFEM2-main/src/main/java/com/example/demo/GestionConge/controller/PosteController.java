package com.example.demo.GestionConge.controller;

import java.util.List;

import com.example.demo.GestionConge.model.dto.posteDto;
import com.example.demo.GestionConge.model.entity.Poste;
import com.example.demo.GestionConge.services.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/postes")
public class PosteController {

	@Autowired
	private PosteService posteService;

	@GetMapping("/getposte")
	public posteDto getPoste(@RequestParam Long id) {

		return posteService.getPoste(id);
	}
	@PostMapping(value={"/postPoste"})
  public posteDto SavePoste( @RequestBody posteDto poste) {
		 return posteService.addPoste(poste);


	}
  
	@PostMapping(value={"/updatePoste"})
	  public  posteDto updatePoste( @RequestBody posteDto poste) {

			return posteService.updatePoste(poste);
		}

	@GetMapping(value={"/deletePoste"})
	public void deletePoste(Long id) {

		 posteService.deletePoste(id);
	}

	@GetMapping(value={"/getallPoste"})
	public List <Poste> getAllPoste( ) {
		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         System.out.println(authentication.getPrincipal().toString());
		return posteService.getAllPoste();
	}
}
