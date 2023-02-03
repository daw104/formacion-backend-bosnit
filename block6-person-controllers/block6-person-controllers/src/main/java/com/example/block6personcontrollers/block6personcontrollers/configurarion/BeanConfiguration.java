package com.example.block6personcontrollers.block6personcontrollers.configurarion;

import com.example.block6personcontrollers.block6personcontrollers.models.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Person bean1(){
        Person person1 = new Person();
        person1.setNombre("bean1");
        person1.setPoblacion("caracas");
        person1.setEdad(20);
        return person1;
    }

    @Bean
    public Person bean2(){
        Person person2 = new Person();
        person2.setNombre("bean2");
        person2.setPoblacion("malaga");
        person2.setEdad(25);
        return person2;
    }

    @Bean
    public Person bean3(){
        Person person3 = new Person();
        person3.setNombre("bean3");
        person3.setPoblacion("logroño");
        person3.setEdad(30);
        return person3;
    }




}
