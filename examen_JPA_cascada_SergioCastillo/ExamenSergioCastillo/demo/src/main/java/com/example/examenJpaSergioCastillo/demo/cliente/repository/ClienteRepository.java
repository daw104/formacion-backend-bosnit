package com.example.examenJpaSergioCastillo.demo.cliente.repository;

import com.example.examenJpaSergioCastillo.demo.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
