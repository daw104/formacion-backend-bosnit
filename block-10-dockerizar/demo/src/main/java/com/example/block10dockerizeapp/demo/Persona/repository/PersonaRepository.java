package com.example.block10dockerizeapp.demo.Persona.repository;


import com.example.block10dockerizeapp.demo.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {


}
