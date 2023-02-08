package com.example.block7crud.block7crud.controller;

import com.example.block7crud.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.block7crud.controller.dto.PersonaOutputDto;
import com.example.block7crud.block7crud.model.Persona;
import com.example.block7crud.block7crud.repository.PersonaRepository;
import com.example.block7crud.block7crud.service.PersonaService;
import com.example.block7crud.block7crud.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    PersonaRepository personaRepository;

    //Añadir persona
    @PostMapping("/addPerson")
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto person) {
        URI location = URI.create("/addPerson");
        return ResponseEntity.created(location).body(personaService.addPerson(person));

    }

    //    Obtener persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonPorNombre(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }




    //    Obtener persona por NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Persona>> getPersonPorNombre(@PathVariable ("nombre") String nombre) {
        try {
            return new ResponseEntity<List<Persona>>(personaRepository.findByNombre(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    //Eliminar persona por id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") int id) {
        try {
            personaService.deletePersonById(id);
            return ResponseEntity.ok().body("Persona con el idd: " + id + " fue eliminada");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    //Todas las personas paginadas
    @GetMapping
    public Iterable<PersonaOutputDto> getAllPersonsPaginadas(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "2", required = false) int pageSize
    ) {

        return personaService.getAllPersonsPaginadas(pageNumber, pageSize);
    }

    //Todas las personas
    @GetMapping("/personas")
    public ArrayList<Persona> getAllPersons() {
        return (ArrayList<Persona>) personaService.getAllPersons();
    }


    //Actualizar persona
    @PutMapping
    public ResponseEntity<PersonaOutputDto> updatePerson(@RequestBody PersonaInputDto person) {
        try {
            personaService.getPersonById(person.getId());
            return ResponseEntity.ok().body(personaService.addPerson(person));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    //Actualizar persona por id,
    @PutMapping("update/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersonPorId(@PathVariable("id") int id, @RequestBody PersonaInputDto person) {
        try {
            person.setId(id);
            PersonaOutputDto updatePerson = personaService.updatePersonPorId(person);
            return new ResponseEntity<>(updatePerson, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
