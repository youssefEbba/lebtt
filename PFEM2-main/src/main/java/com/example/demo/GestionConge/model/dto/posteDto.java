package com.example.demo.GestionConge.model.dto;

import com.example.demo.GestionConge.model.entity.Poste;
import com.example.demo.GestionConge.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class posteDto {

    private Long id;
    private String type;
    private String nom;
    //@OneToMany(mappedBy="poste", fetch= FetchType.LAZY )
    private Collection<Employee> users;

    public static posteDto toDto(Poste poste){
    return posteDto.builder()
            .id(poste.getId())
            .type(poste.getType())
            .nom(poste.getNom())
            .build();

    }
}
