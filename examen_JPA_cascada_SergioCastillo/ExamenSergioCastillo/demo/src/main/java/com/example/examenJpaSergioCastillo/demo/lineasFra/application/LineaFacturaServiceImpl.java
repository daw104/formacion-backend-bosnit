package com.example.examenJpaSergioCastillo.demo.lineasFra.application;

import com.example.examenJpaSergioCastillo.demo.Errors.Request404;
import com.example.examenJpaSergioCastillo.demo.Errors.Request422;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.controller.dto.FacturaOutputDto;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.repository.CabeceraFraRepository;
import com.example.examenJpaSergioCastillo.demo.lineasFra.controller.dto.LineaFacturaInputDto;
import com.example.examenJpaSergioCastillo.demo.lineasFra.domain.LineaFra;
import com.example.examenJpaSergioCastillo.demo.lineasFra.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaFacturaServiceImpl implements LineaFacturaService {

    @Autowired
    LineaFraRepository lineaFraRepository;

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;


    @Override
    public FacturaOutputDto addLinea(LineaFacturaInputDto lineaFacturaInputDto, int id) throws Request404, Request422 {

        LineaFra lineaFra = new LineaFra();

        //comprobamos que el producto venga vacio
        if(lineaFacturaInputDto.getProducto().isEmpty() || lineaFacturaInputDto.getProducto().isBlank()){
            throw new Request422("El producto no puede estar vacio");
        }
        lineaFra.setProNomb(lineaFacturaInputDto.getProducto());
        lineaFra.setCantidad(lineaFacturaInputDto.getCantidad());
        lineaFra.setPrecio(lineaFacturaInputDto.getPrecio());

        //comprobamos que la factura exista en db
        if(  cabeceraFraRepository.existsById(id)){
            CabeceraFra factura = cabeceraFraRepository.findById(id).get();
            lineaFra.setCabeceraFra(factura);
        }else{
            throw new Request404("No existe la factura con el id " + id );
        }
        lineaFraRepository.save(lineaFra);

        //imprimimos facturaOutputDto
        FacturaOutputDto facturaOutputDto = new FacturaOutputDto(cabeceraFraRepository.findById(id)
                .orElseThrow(() -> new Request404("no existe la Factura con el id " + id)));

        return facturaOutputDto;

    }


}
