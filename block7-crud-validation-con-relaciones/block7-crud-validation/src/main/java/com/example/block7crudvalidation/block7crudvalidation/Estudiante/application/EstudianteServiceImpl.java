package com.example.block7crudvalidation.block7crudvalidation.Estudiante.application;

import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteSimpleOutputDto;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.example.block7crudvalidation.block7crudvalidation.Estudiante.repository.EstudianteRepository;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request404;
import com.example.block7crudvalidation.block7crudvalidation.Persona.Errors.Request422;
import com.example.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.example.block7crudvalidation.block7crudvalidation.Persona.repository.PersonaRepository;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.example.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;


    @Override
    public EstudianteSimpleOutputDto updateEstudiante(EstudianteInputDto estudiante) throws Exception {

        Request404 request404 = new Request404("No existe el estudiante con el id " + estudiante.getId_student());

        Estudiante estudianteExistente = estudianteRepository.findById(estudiante.getId_student())
                .orElseThrow(() -> request404);


        if (estudiante.getNum_hours_week() != 0) {
            estudianteExistente.setNum_hours_week(estudiante.getNum_hours_week());
        }

        if (estudiante.getComents() != null) {
            estudianteExistente.setComents(estudiante.getComents());
        }

        if (estudiante.getBranch() != null) {
            estudianteExistente.setBranch(estudiante.getBranch());
        }

        estudianteRepository.save(estudianteExistente);
        return new EstudianteSimpleOutputDto(estudianteExistente);


    }


    @Override
    public EstudianteSimpleOutputDto getEstudianteById(int id, String outputType) throws Request404 {
//        EstudianteSimpleOutputDto estudianteSimpleOutputDto = new EstudianteSimpleOutputDto(estudiante);

        switch (outputType) {
            case "full" -> {
                Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new Request404("no existe el Estudiante con el id" + id));
                return new EstudianteOutputDto(estudiante);
            }
            case "simple" -> {
                Estudiante estudiante1 = estudianteRepository.findById(id).orElseThrow(() -> new Request404("no existe el Estudiante con el id" + id));
                return new EstudianteSimpleOutputDto(estudiante1);
            }
            default -> throw new Request422("Selecciona si quieres la informacion full o simple en el outputType");
        }

    } //*************FIN DE METODO


    //-*****-Eliminar Estudiante
  


    //-*****-Todas los estudiantes
    @Override
    public List<EstudianteOutputDto> getAllEstudiantes() {

        List<EstudianteOutputDto> lista = new ArrayList<>();
        for (var p : estudianteRepository.findAll()) {
            lista.add(new EstudianteOutputDto(p));
        }
        return lista;

    }//-*****-Todos los estudiantes


    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) {
        Request404 request404 = new Request404("Esta persona ya es un estudiante");

        Estudiante estudiante = new Estudiante();

        Persona persona = personaRepository.findById(estudianteInputDto.getPersona().getId_persona())
                .orElseThrow(() -> new Request404("No existe el la Persona con el id " + estudianteInputDto.getPersona().getId_persona()));


        for (Estudiante e : estudianteRepository.findAll()) {
            if (e.getPersona().getId_persona() == (estudianteInputDto.getPersona().getId_persona())) {
                throw new Request422("Estudiante ya registrado con este id Persona");
            }
        }

        //busco la persona y compruebo si existe
        estudiante.setPersona(persona);

        //busco el profesor para asociarlo
        estudiante.setProfesor(profesorRepository.findById(estudianteInputDto.getProfesor().getId_profesor())
                .orElseThrow(() -> new Request404("No existe el profesor con el id " + estudianteInputDto.getProfesor().getId_profesor())));


        //seteo los campos del estudiante
            estudiante.getPersona().setEstudiante(estudiante);

            estudiante.setNum_hours_week(estudianteInputDto.getNum_hours_week());
            estudiante.setComents(estudianteInputDto.getComents());
            estudiante.setBranch(estudianteInputDto.getBranch());

            estudianteRepository.save(estudiante);

            EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudiante);
            return estudianteOutputDto;


    }


}
