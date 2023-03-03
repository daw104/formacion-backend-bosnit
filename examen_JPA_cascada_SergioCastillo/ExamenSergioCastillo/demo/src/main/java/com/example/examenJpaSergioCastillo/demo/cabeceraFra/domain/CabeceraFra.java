package com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain;


import com.example.examenJpaSergioCastillo.demo.cliente.domain.Cliente;
import com.example.examenJpaSergioCastillo.demo.lineasFra.domain.LineaFra;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cabeceraFra")
public class CabeceraFra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double ImporteFra;

    //relacion 1-n con los Clientes LAZY
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cli_codi")
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "cabeceraFra", cascade = CascadeType.REMOVE, orphanRemoval = true) // Con el cascadetype remove, puedo remover la lista de las lineas asociadas

    @JsonManagedReference
    private List<LineaFra> lineaFraList;



//    constructor para crear la FACTURA por defecto cuando se inicialize el programa
    public CabeceraFra(double importeFra, Cliente cliente) {
        ImporteFra = importeFra;
        this.cliente = cliente;
    }
}
