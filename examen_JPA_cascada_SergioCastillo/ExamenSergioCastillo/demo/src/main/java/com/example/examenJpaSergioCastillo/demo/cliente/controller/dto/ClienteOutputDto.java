package com.example.examenJpaSergioCastillo.demo.cliente.controller.dto;

import com.example.examenJpaSergioCastillo.demo.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDto {

    int id;
    String nombre;

    public ClienteOutputDto(Cliente cliente){
        this.setId(cliente.getId());
        this.setNombre(cliente.getNombre());
    }

}
