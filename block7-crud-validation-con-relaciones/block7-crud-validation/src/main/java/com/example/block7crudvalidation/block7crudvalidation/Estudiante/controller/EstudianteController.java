package com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.application.EstudianteServiceImpl;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteServiceImpl estudianteService;


    @PostMapping("/addEstudiante")
    public ResponseEntity<EstudianteOutputDto> addEstudiante(@RequestBody EstudianteInputDto inputDtoEstudiante) throws Exception {
        return new ResponseEntity<>(estudianteService.addEstudiante(inputDtoEstudiante), HttpStatus.OK);

    }

    @GetMapping("/get-all-estudiantes")
    public Iterable<EstudianteOutputDto> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEstudianteById(@PathVariable ("id") int id) throws Request404 {
            estudianteService.deleteEstudianteById(id);
            return new ResponseEntity<>("Estudiante con el id " + id + " eliminada", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public EstudianteSimpleOutputDto getEstudianteById(@PathVariable ("id") int id, @RequestParam String outputType) throws Request404{
           return estudianteService.getEstudianteById(id, outputType);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EstudianteSimpleOutputDto> updateEstudiante(@PathVariable ("id") int id, @RequestBody EstudianteInputDto estudiante) throws Exception {
        estudiante.setId_student(id);
        return new ResponseEntity<>(estudianteService.updateEstudiante(estudiante), HttpStatus.OK);

    }




}
