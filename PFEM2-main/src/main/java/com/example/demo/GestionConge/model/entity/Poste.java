package com.example.demo.GestionConge.model.entity;

import java.util.ArrayList;
import java.util.Collection;


//import com.example.demo.GestionConge.model.dto.posteDto;
import com.example.demo.GestionConge.model.dto.posteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="poste")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="poste_id ")
	private Long id;
	@Column(name ="poste_type ")
	private String type;
	private String nom;


	@OneToMany(mappedBy="poste", fetch=FetchType.EAGER )
	private Collection <Employee> employees=new ArrayList<>();

    public static Poste toEntity(posteDto dto){
		return Poste.builder()
				.id(dto.getId())
				.type(dto.getType())
				.nom(dto.getNom())
				.build();
	}

}


