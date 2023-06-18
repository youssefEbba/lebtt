package com.example.demo.GestionConge.model.dto;

import com.example.demo.GestionConge.model.entity.DemandeConge;
import com.example.demo.GestionConge.model.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeCongeDto {
    private Long id;
    private Date dateDébut =new Date();
    private  Date dateFin;
    private Employee employee;

    public static DemandeCongeDto DemandetoDto(DemandeConge demandeCon ){
        return DemandeCongeDto.builder()
                .id(demandeCon.getId()) 
                .dateDébut(demandeCon.getDateDébut())
                .dateFin(demandeCon.getDateFin())
                .employee(demandeCon.getEmployee())
                .build();

    }
}
