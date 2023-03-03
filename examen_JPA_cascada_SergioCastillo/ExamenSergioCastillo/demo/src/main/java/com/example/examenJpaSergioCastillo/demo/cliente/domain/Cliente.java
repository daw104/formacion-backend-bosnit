package com.example.examenJpaSergioCastillo.demo.cliente.domain;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<CabeceraFra> factura;

    //constructor para poder inicializar el cliente por defecto cuando se inicialice el programa
    public Cliente(String nombre) {
        this.nombre = nombre;
    }


}
