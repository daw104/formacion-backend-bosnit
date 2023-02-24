package com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaFullOutputDto extends AsignaturaOutputDto {

    List<EstudianteSimpleOutputDto> listaestudianteSimpleOutputDto;

    public AsignaturaFullOutputDto(Asignatura asignatura){
        super(asignatura);
        this.setListaestudianteSimpleOutputDto(new ArrayList<EstudianteSimpleOutputDto>()); //Seteo y inicializo

        for (Estudiante estudiante: asignatura.getEstudiante()){
            listaestudianteSimpleOutputDto.add(new EstudianteSimpleOutputDto(estudiante));
        }
    }



}
