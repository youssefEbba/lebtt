package com.example.demo.GestionConge.model.dto;

import com.example.demo.GestionConge.model.entity.*;
import com.example.demo.GestionConge.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Integer id;

    private String matricule;

    private String phone_number;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private   Long NNI ;

    //@Enumerated(EnumType.STRING )
    private Role role;

//    @OneToMany(mappedBy = "user")
//    private List<Token> tokens;
    private Collection<DemandeConge> demandeConges;


    private Poste poste;


    private CompteConge compteConge;

    public static EmployeeDto EtoDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .matricule(employee.getMatricule())
                .phone_number(employee.getPhone_number())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .email(employee.getEmail())
                //.password(employee.getPassword())
                .NNI(employee.getNNI())
                .role(employee.getRole())
                .demandeConges(employee.getDemandeConges())
                .poste(employee.getPoste())
                .compteConge(employee.getCompteConge())

                .build();

    }


}
