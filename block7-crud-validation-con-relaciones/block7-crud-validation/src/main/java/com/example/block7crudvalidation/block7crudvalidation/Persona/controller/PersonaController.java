package com.example.block7crudvalidation.block7crudvalidation.Persona.controller;

import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Persona.application.PersonaServiceImpl;
import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Persona.feign.MyFeign;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.application.ProfesorServiceImpl;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    ProfesorServiceImpl profesorService;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    MyFeign myFeign;


    @PostMapping("/addPerson")
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto person) throws Exception {
        return new ResponseEntity<>(personaService.addPerson(person),HttpStatus.OK);

    }

    @GetMapping("/get-all-persons")
    public Iterable<PersonaOutputDto> getAllPersons() {
        return personaService.getAllPersons();
    }

    @GetMapping("/get-person-by-name/{name}")
    public ResponseEntity<List<Persona>> getPersonPorNombre(@PathVariable ("name") String name) {
        try {
            return new ResponseEntity<List<Persona>>(personaService.getPersonPorNombre(name), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getPersonById/{id}")
    public PersonaOutputDto getPersonById(@PathVariable ("id") int id) throws Request404 {

        return personaService.getPersonById(id);
    }



    @DeleteMapping("/deletePersonById/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable ("id") int id) throws Request404{
        personaService.deletePersonById(id);
        return new ResponseEntity<>("Persona con el id " + id + " eliminada", HttpStatus.OK);
    }


    @PutMapping("updatePerson/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersonPorId(@PathVariable ("id") int id, @RequestBody PersonaInputDto personaInputDto) throws Exception{
        personaInputDto.setId_persona(id);
        return new ResponseEntity<>(personaService.updatePersonPorId(personaInputDto), HttpStatus.OK);
    }

    @GetMapping("/profesor/get/{id}")
    public ResponseEntity<ProfesorSimpleOutputDto> getProfesorIdFeign(@PathVariable int id, @RequestParam String outputType){
       return new ResponseEntity<ProfesorSimpleOutputDto>(myFeign.getProfesorIdFeign(id, outputType), HttpStatus.OK);

    }





}
