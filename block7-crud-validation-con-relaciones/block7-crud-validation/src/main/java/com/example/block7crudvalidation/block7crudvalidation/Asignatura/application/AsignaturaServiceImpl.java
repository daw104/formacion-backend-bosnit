package com.example.block7crudvalidation.block7crudvalidation.Asignatura.application;

import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaFullOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.example.block7crudvalidation.block7crudvalidation.Asignatura.repository.AsignaturaRepository;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.repository.EstudianteRepository;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request422;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {


    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<AsignaturaFullOutputDto> getAtllAsignaturas() {

        List<AsignaturaFullOutputDto> lista = new ArrayList<>();
        for (var p : asignaturaRepository.findAll()) {
            lista.add(new AsignaturaFullOutputDto(p));
        }
        return lista;
    }

    @Override
    public AsignaturaOutputDto getAsignatura(int id, String outputType) throws Request404 {

        switch (outputType) {
            case "full" -> {
                Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new Request404("no existe La Asignatura con el id" + id));
                return new AsignaturaFullOutputDto(asignatura);
            }
            case "simple" -> {
                Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new Request404("no existe La Asignatura con el id" + id));
                return new AsignaturaOutputDto(asignatura);
            }
            default -> throw new Request422("Selecciona si quieres la informacion full o simple en el outputType");
        }


    }


    @Override
    public Asignatura asignarEstudianteAsignatura(int idAsignatura, int idEstudiante) throws Request422 {
        List<Estudiante> listEstudiantes = null;

        Estudiante estudiante = estudianteRepository.findById(idEstudiante).get();
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).get();


        listEstudiantes = asignatura.getEstudiante();
        listEstudiantes.add(estudiante);
        asignatura.setEstudiante(listEstudiantes);
        return asignaturaRepository.save(asignatura);


    }


    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {

        return new AsignaturaOutputDto(asignaturaRepository.save(asignaturaInputDto.inputDtoAsignatura()));

    }


    @Override
    public void deleteAsignaturaById(int id) throws Request404 {
        Request404 request404 = new Request404("No existe la asignatura con el id " + id);
        if (asignaturaRepository.existsById(id)) {
            asignaturaRepository.deleteById(id);
        } else {
            throw request404;
        }

    }


}
