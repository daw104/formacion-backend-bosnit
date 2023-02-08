package com.example.block7crud.block7crud.repository;

import com.example.block7crud.block7crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findByNombre(String nombre);

}
