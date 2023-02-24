package com.example.block7crudvalidation.block7crudvalidation.Estudiante.application;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EstudianteService {


    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto);

    List<EstudianteOutputDto> getAllEstudiantes();

    void deleteEstudianteById(int id) throws Request404;

    EstudianteSimpleOutputDto getEstudianteById(int id, String outputType) throws Request404;

    EstudianteSimpleOutputDto updateEstudiante(EstudianteInputDto estudiante) throws Exception;




}
