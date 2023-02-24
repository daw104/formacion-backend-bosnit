package com.example.block10dockerizeapp.demo.Persona.controller;

import com.example.block10dockerizeapp.demo.Persona.Errors.Request404;
import com.example.block10dockerizeapp.demo.Persona.application.PersonaServiceImpl;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaInputDto;
import com.example.block10dockerizeapp.demo.Persona.controller.dto.PersonaOutputDto;
import com.example.block10dockerizeapp.demo.Persona.domain.Persona;
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


    @PostMapping("/addPerson")
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto person) throws Exception {
        return new ResponseEntity<>(personaService.addPerson(person), HttpStatus.OK);

    }

    @GetMapping("/get-all-persons")
    public Iterable<PersonaOutputDto> getAllPersons() {
        return personaService.getAllPersons();
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



}
