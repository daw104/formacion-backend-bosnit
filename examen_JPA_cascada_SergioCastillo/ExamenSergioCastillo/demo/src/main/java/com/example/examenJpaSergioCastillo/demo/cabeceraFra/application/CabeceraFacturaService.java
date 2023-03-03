package com.example.examenJpaSergioCastillo.demo.cabeceraFra.application;

import com.example.examenJpaSergioCastillo.demo.Errors.Request404;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CabeceraFacturaService {

    //todas las facturas
    List<FacturaOutputDto> getFacturas();

    //Eliminar una factura
    void deleteFactura(int id) throws Request404;



}
