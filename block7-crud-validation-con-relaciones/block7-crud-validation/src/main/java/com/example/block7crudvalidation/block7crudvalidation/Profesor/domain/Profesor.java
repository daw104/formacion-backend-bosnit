package com.example.block7crudvalidation.block7crudvalidation.Profesor.domain;


import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_profesor;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch")
    private String branch;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "profesor")
    private List<Estudiante> estudiante;


}
