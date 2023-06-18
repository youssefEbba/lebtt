package com.example.demo.GestionConge.model.entity;

import java.util.Collection;
import java.util.Date;

import com.example.demo.GestionConge.model.dto.CompteCongeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CompteConge{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="compteconge_id")
	private Long id;
	private int NomberJoure=24;

	private Date date;

	@OneToOne( fetch = FetchType.EAGER )
	@JoinColumn(name="employee_id" )
	private Employee employee;

	public static CompteConge CDtotoEntity(CompteCongeDto dto){
		return CompteConge.builder()
				.id(dto.getId())
				.NomberJoure(dto.getNomberJoure())
				.date(dto.getDate())
				.employee(dto.getEmployee())
				.build();
	}





}