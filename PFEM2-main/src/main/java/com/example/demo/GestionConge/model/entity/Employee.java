package com.example.demo.GestionConge.model.entity;


import com.example.demo.GestionConge.model.dto.DirectionDto;
import com.example.demo.GestionConge.model.dto.EmployeeDto;
import com.example.demo.GestionConge.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String matricule;

    private String phone_number;
    
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private   Long NNI ;

    @Enumerated(EnumType.STRING )
    private Role role;
     
    @OneToMany(mappedBy = "user" ,fetch=FetchType.EAGER )
    private Set<Token> tokens;

    @OneToMany(mappedBy="employee", fetch=FetchType.EAGER )
    private Collection<DemandeConge> demandeConges;

    @ManyToOne
    @JoinColumn(name="poste")
    private Poste poste;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="compteConge")
    private CompteConge compteConge;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
      return password;
    }
  
    @Override
    public String getUsername() {
      return email;
    }
  
    @Override
    public boolean isAccountNonExpired() {
      return true;
    }
  
    @Override
    public boolean isAccountNonLocked() {
      return true;
    }
  
    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }
  
    @Override
    public boolean isEnabled() {
      return true;
    }

    public static Employee EDtotoEntity(EmployeeDto dto){
        return Employee.builder()
                .id(dto.getId())
                .matricule(dto.getMatricule())
                .phone_number(dto.getPhone_number())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                //s.password(dto.getPassword())
                .NNI(dto.getNNI())
                .role(dto.getRole())
                .demandeConges(dto.getDemandeConges())
                .poste(dto.getPoste())
                .compteConge(dto.getCompteConge())

                .build();
    }




}
