package com.example.demo.GestionConge.model.dto;
import com.example.demo.GestionConge.model.entity.CompteConge;
import com.example.demo.GestionConge.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompteCongeDto {

    private Long id;
    private int NomberJoure=24;

    private Date date;

    private Employee employee;

    public static CompteCongeDto CtoDto(CompteConge compteConge){
        return CompteCongeDto.builder()
                .id(compteConge.getId())
                .NomberJoure(compteConge.getNomberJoure())
                .date(compteConge.getDate())
                .employee(compteConge.getEmployee())
                .build();

    }
}
