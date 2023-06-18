package com.example.demo.GestionConge.model.entity;

import java.util.Date;

import com.example.demo.GestionConge.model.dto.DemandeCongeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor	
@AllArgsConstructor
public class DemandeConge{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name ="demandeconge_id ")
	  private Long id;
	private  Date date =new Date();
	  private  Date dateDébut;
	  private  Date dateFin;
	  @ManyToOne
	  @JoinColumn(name="demandeConge")
	   private Employee employee;
	 @ManyToOne
	 @JoinColumn(name="demandeCongees")
	  private Direction direction;
	  public static DemandeConge demtoEntity(DemandeCongeDto dto){
		  return DemandeConge.builder()
				.id(dto.getId())
				.dateDébut(dto.getDateDébut())
				.dateFin(dto.getDateFin())
				.employee(dto.getEmployee())
				.build();
	}
}