package org.example;


import person.InvalidLineFormatExecption;
import person.Metodos;
import person.Person;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvalidLineFormatExecption {

        Metodos m1 = new Metodos();

        List<Person>listaPersona = new ArrayList<>();
        System.out.println("----------------Primer Metodo, leo el fichero e imprimo lista de personas completa");
        listaPersona =  m1.crearListaPersonas();//imprime todos la lista pero sigue sin resolver la ultima posicion del array
        System.out.println("-----------------Personsa que no empiezan con la letra A");
        m1.filtraPrimeraLetra(listaPersona);
        System.out.println("-----------------Edad flitrada con menos de 25 años");
        m1.filtradEdad(listaPersona);
        System.out.println("-----------------Primera persona cuya ciudad sea Madrid");
        m1.primerElementoMadrid(listaPersona);
        System.out.println("-----------------Primera persona cuya ciudad sea Barcelona");
        m1.primerElementoBarcelona(listaPersona);


    }



}