package com.example.demo.GestionConge.controller;

import com.example.demo.GestionConge.model.dto.CompteCongeDto;
import com.example.demo.GestionConge.model.entity.CompteConge;
import com.example.demo.GestionConge.services.CompteCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="comptConges")
public class CompteCongeController {

    @Autowired
    private CompteCongeService compteCongeService;

    @GetMapping("/getCompteConge")
    public CompteCongeDto getCompteConge(@RequestParam Long id) {

        return compteCongeService.findByID(id);
    }
    @PostMapping(value={"/postCompteConge"})
    public CompteCongeDto SaveCompteConge( @RequestBody CompteCongeDto compteCongeDto) {
        return compteCongeService.addCompteConge(compteCongeDto);
    }

    @PostMapping(value={"/updateCompteConge"})
    public CompteCongeDto updateCompteConge( @RequestBody CompteCongeDto compteCongeDto) {

        return compteCongeService.updateCompteConge(compteCongeDto);
    }

    @GetMapping(value={"/deleteCompteConge"})
    public void deleteCompteConge(Long id) {

        compteCongeService.deleteCompteConge(id);
    }

    @GetMapping(value={"/getallCompteConge"})
    public List<CompteConge> getAllCompteConge( ) {
        return compteCongeService.getAllCompteConge();
    }



}
