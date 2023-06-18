package com.example.demo.GestionConge.model.dto;

import com.example.demo.GestionConge.model.entity.Direction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectionDto {

    private Long id;
    private  String division;


    public static DirectionDto DtoDto(Direction direction){
        return DirectionDto.builder()
                .id(direction.getId())
                .division(direction.getDivision())

                .build();

    }

}

