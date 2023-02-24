package com.example.block7crudvalidation.block7crudvalidation.Persona.repository;

import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findByName(String name); //para luego buscar por nombre

}
