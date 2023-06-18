package com.example.demo.GestionConge.security.auth;

import com.example.demo.GestionConge.model.entity.CompteConge;
import com.example.demo.GestionConge.model.entity.DemandeConge;
import com.example.demo.GestionConge.model.entity.Poste;
import com.example.demo.GestionConge.model.entity.Role;
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
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

//  private String firstname;
//  private String lastname;
//  private String email;
//  private String password;
// private Role role;

    private String matricule;

    private String phone_number;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private   Long NNI ;

    private Role role;

    private Collection<DemandeConge> demandeConges;


    private Poste poste;


    private CompteConge compteConge;

}