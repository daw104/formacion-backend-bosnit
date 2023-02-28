package com.example.block11cors.demo.Person.repository;

import com.example.block11cors.demo.Person.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
