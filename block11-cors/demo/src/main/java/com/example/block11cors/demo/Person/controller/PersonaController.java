package com.example.block11cors.demo.Person.controller;

import com.example.block11cors.demo.Person.Errors.Request404;
import com.example.block11cors.demo.Person.application.PersonaServiceImpl;
import com.example.block11cors.demo.Person.controller.dto.PersonaInputDto;
import com.example.block11cors.demo.Person.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @CrossOrigin()
//HAY QUE PONER ESTA URL PARA PODER CONSUMIR LOS DATOS EN EL CLIENTE fetch('http://localhost:8080/persona/addperson'
    @PostMapping("/addperson")
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto person) throws Exception {
        return new ResponseEntity<>(personaService.addPerson(person), HttpStatus.OK);

    }

    @CrossOrigin()
//HAY QUE PONER ESTA URL PARA PODER CONSUMIR LOS DATOS EN EL CLIENTE fetch('http://localhost:8080/persona/getall'
    @GetMapping("/getall")
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
