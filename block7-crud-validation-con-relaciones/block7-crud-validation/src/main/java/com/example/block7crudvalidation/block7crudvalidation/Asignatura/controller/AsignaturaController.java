package com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.application.AsignaturaServiceImpl;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaFullOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("asignatura")
public class AsignaturaController {

        @Autowired
    AsignaturaServiceImpl asignaturaService;


    @GetMapping("/get-all")
    public Iterable<AsignaturaFullOutputDto> getAtllAsignaturas() {
        return asignaturaService.getAtllAsignaturas();
    }



    @GetMapping("/get/{id}")
    public AsignaturaOutputDto getAsignatura(@PathVariable ("id") int id, @RequestParam String outputType){
        return asignaturaService.getAsignatura(id, outputType);
    }


    @PostMapping("/add")
    public ResponseEntity<AsignaturaOutputDto> addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws Exception{
        return  new ResponseEntity<>(asignaturaService.addAsignatura(asignaturaInputDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAsignaturaById(@PathVariable ("id") int id) throws Request404 {
        asignaturaService.deleteAsignaturaById(id);
        return new ResponseEntity<>("Asignatura con el id " + id + " eliminada", HttpStatus.OK);
    }


    @PutMapping("estudiante/{id_estudiante}/asignatura/{id_asignatura}")
    public Asignatura asignarEstudianteAsignatura(
            @PathVariable int id_asignatura,
            @PathVariable int id_estudiante
            )
    {
        return asignaturaService.asignarEstudianteAsignatura(id_asignatura, id_estudiante );
    }



}
