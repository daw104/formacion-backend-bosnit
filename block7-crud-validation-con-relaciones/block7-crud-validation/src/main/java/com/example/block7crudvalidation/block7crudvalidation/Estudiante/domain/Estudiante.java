package com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_student;

    @Column(name = "horas_por_semana")
    int num_hours_week;
    @Column(name = "comentarios")
    private String coments;


    @Column(name = "rama")
    private String branch;


    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;


    @JsonIgnore
    @ManyToMany(mappedBy = "estudiante")
    private List<Asignatura> asignatura;

}
