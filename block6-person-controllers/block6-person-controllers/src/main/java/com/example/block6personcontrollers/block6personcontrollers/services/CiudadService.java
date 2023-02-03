package com.example.block6personcontrollers.block6personcontrollers.services;



import com.example.block6personcontrollers.block6personcontrollers.models.Ciudad;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class CiudadService {

    private Ciudad ciudad;

    //la lista tiene que esta en el modelo
    private List<Ciudad> cargarCiudades(){
        List<Ciudad> ciudadObject = new ArrayList<>();
        return ciudadObject;
    }

    private List<Ciudad> ciudades = cargarCiudades();

    public List<Ciudad> getAllciudades() {
        return ciudades;
    }


    public String addCiudades(Ciudad ciudad){
            ciudades.add(ciudad);
            return "ciudadad añadida satisfactoriamente";
    }



}
