package com.example.demo.GestionConge.controller;//package com.example.demo.GestionConge.controllers;

import com.example.demo.GestionConge.model.dto.DemandeCongeDto;
import com.example.demo.GestionConge.model.entity.DemandeConge;
import com.example.demo.GestionConge.services.DemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/demande")
public class DemandeCongeController {
@Autowired
private DemandeCongeService demandeCongeService;
    @GetMapping("/getDemande")
    public DemandeCongeDto getDirection(@RequestParam Long id) {

        return demandeCongeService.getDemande(id);
    }
    @PostMapping(value={"/postDemande"})
    public DemandeCongeDto SavePoste( @RequestBody DemandeCongeDto dmnd) {
        return demandeCongeService.addDemande(dmnd);
    }

    @PostMapping(value={"/updateDemande"})
    public DemandeCongeDto updatePoste(@RequestBody DemandeCongeDto dmnd) {

        return demandeCongeService.updateDemande(dmnd);
    }

    @GetMapping(value={"/deleteDemande"})
    public void deletePoste(Long id) {

        demandeCongeService.deleteDemande(id);
    }

    @GetMapping(value={"/getallDemande"})
    public List<DemandeConge> getAllPoste( ) {
        return demandeCongeService.getAllDemande();
    }

}
