package com.example.block7crudvalidation.block7crudvalidation.Persona.feign;


import com.example.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorSimpleOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "http://localhost:8081", name = "MyFeign")
public interface MyFeign {


    @GetMapping("/profesor/get/{id}")
     ProfesorSimpleOutputDto getProfesorIdFeign(@PathVariable int id, @RequestParam String outputType);

}
