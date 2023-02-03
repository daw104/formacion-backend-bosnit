package com.example.block6personcontrollers.block6personcontrollers.controllers;

import com.example.block6personcontrollers.block6personcontrollers.models.Person;
import com.example.block6personcontrollers.block6personcontrollers.configurarion.BeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beanController")
public class BeanController {

    @Autowired
    @Qualifier("bean1")
    private Person person1;

    @Autowired
    @Qualifier("bean2")
    private Person person2;

    @Autowired
    @Qualifier("bean3")
    private Person person3;

    @GetMapping(value = "beans/{bean}")
    public Person getBean(@PathVariable String bean){
        if(bean.equals("bean1")){ // Assuming VehicleType is an enum
            return person1;
        } else if (bean.equals("bean2")){
            return person2;
        } else if (bean.equals("bean3")){
            return person3;
        }else {
            throw new IllegalArgumentException("No hay bean disponible con este nombre: " + bean);
        }
    }


}
