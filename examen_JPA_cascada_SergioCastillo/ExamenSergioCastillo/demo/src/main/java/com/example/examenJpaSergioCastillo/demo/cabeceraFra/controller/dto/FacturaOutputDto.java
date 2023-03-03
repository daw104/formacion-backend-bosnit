package com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.example.examenJpaSergioCastillo.demo.cliente.controller.dto.ClienteOutputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto.LineaFacturaOutputDto;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaOutputDto {

    int id;

    double importeFra=0;

//    Cliente cliente;
    ClienteOutputDto clienteOutputDto;

//   List<LineaFra> lineaFra;
    List<LineaFacturaOutputDto> lineaFacturaOutputDto;
    public FacturaOutputDto(CabeceraFra factura){

        this.setId(factura.getId());
        this.setImporteFra(factura.getImporteFra());
        this.setClienteOutputDto(new ClienteOutputDto(factura.getCliente()));
        this.setLineaFacturaOutputDto(new ArrayList<LineaFacturaOutputDto>());

        for (int i= 0; i < factura.getLineaFraList().size(); i++){
                //por cada vuelta, añado al output la linea
                lineaFacturaOutputDto.add( new LineaFacturaOutputDto(factura.getLineaFraList().get(i)));
        }

    }


}
