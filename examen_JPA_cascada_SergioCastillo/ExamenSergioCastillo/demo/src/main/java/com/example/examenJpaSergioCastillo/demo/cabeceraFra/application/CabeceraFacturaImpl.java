package com.example.examenJpaSergioCastillo.demo.cabeceraFra.application;

import com.example.examenJpaSergioCastillo.demo.Errors.Request404;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.repository.CabeceraFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabeceraFacturaImpl implements CabeceraFacturaService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;


    @Override
    public List<FacturaOutputDto> getFacturas(){
        List<FacturaOutputDto> listaFacturas = new ArrayList<>();
        for (var i: cabeceraFraRepository.findAll() ){
            listaFacturas.add(new FacturaOutputDto(i));
        }
        return listaFacturas;
    } //-*****-fin de metodo


    @Override
    public void deleteFactura(int id) throws Request404 {
        Request404 request404 = new Request404("No existe la factura con el id " + id);
        if (cabeceraFraRepository.existsById(id)) {
            cabeceraFraRepository.deleteById(id);
        } else {
            throw request404;
        }

    } //-*****-fin de metodo



}
