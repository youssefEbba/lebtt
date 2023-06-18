package com.example.demo.GestionConge.model.entity;

import com.example.demo.GestionConge.model.dto.DirectionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="direction_id ")
	private Long id;
	private  String division;
	@OneToMany(mappedBy="direction", fetch=FetchType.LAZY )
	private Collection<DemandeConge> demandeCongees;

	public static Direction dDtotoEntity(DirectionDto dto){
		return Direction.builder()
				.id(dto.getId())
		        .division(dto.getDivision())

				.build();
	}


}