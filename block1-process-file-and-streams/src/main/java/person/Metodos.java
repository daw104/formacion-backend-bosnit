package person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Metodos {

    //    Leer el fichero
    public void readFile() throws IOException {
        //leemos el fichero
        String path = ("src/main/resources/people.cvs");
        FileReader fr = new FileReader(path); //lee el fichero que le estoy pasando en el path

        BufferedReader br = new BufferedReader(fr); //tiene un metodo que lee linea a linea, por eso lo utilizo
        String linea = br.readLine(); // leo linea a linea el fichero

        List<Person> personList = new ArrayList<>(); //lista de personas donde guardare el content del file

//        impirmir cada linea y que salga separado
        String[] datosPersona = linea.split(":");

        Person person1 = new Person(datosPersona[0], datosPersona[1], Integer.parseInt(datosPersona[2]));
        System.out.println("Name: " + person1.getName() + " Town: " + person1.getTown() + " Age: " + person1.getAge());

    }

        public List<Person> crearListaPersonas() throws IOException, InvalidLineFormatExecption {
                //leemos el fichero
                String path = ("src/main/resources/people.cvs");
                FileReader fr = new FileReader(path); //lee el fichero que le estoy pasando en el path

                BufferedReader br = new BufferedReader(fr); //tiene un metodo que lee linea a linea, por eso lo utilizo
                String linea = br.readLine(); // leo linea a linea el fichero

                List<Person> personList = new ArrayList<>(); //lista de personas donde guardare el content del file


                while (linea != null) {
                    //      separo cada linea por :
                    String[] datosPersona = linea.split(":");
                    Person person = new Person();

                    long contador = linea.chars().filter(c -> c == ':').count();

                    if(contador == 0){
                        throw new InvalidLineFormatExecption("Faltan dos delimitadores");
                    } else if (contador == 1) {
                        throw new InvalidLineFormatExecption("Falta Un delimitadores");
                    }

                        if(datosPersona[1].isBlank() || datosPersona[1].isEmpty()){
                            person.setName(datosPersona[0]);
                            person.setTown(datosPersona[1] = "" );
                            person.setAge(Integer.parseInt(datosPersona[2]));
                        }

                    person.setName(datosPersona[0]);
                    person.setTown(datosPersona[1]);
                    if(datosPersona.length > 2){
                        person.setAge(Integer.parseInt(datosPersona[2]));
                    }else{
                        person.setAge(0);
                    }




                    //Si el nombre de la persona esta vacio, lanza error
                    if(datosPersona[0].isBlank() || datosPersona[0].isEmpty()){
                        System.out.println(person.getTown() + ": " + person.getAge() + " El nombre es Obligatorio ");
                    }

                    personList.add(person);
                    // leo la siguiente linea
                    linea = br.readLine();

                    System.out.println("Name: " + person.getName() + " Town: " + person.getTown() + " Age: " + person.getAge());
                }

                return personList;

    }


        //filtrado A
        public void filtradEdad(List<Person>personaList){
            List<Person>listaFiltrada = personaList.stream()
                    .filter(p -> (p.getAge() > 0 && p.getAge() <=25))
                    .collect(Collectors.toList());

            for (Person person: listaFiltrada){
                System.out.println( "Name: " + person.getName() + " Town: " + person.getTown()  + " Age: " + person.getAge());
            }

        }


        //Filtrado B
        public void filtraPrimeraLetra(List<Person>personaList){
                List<Person>listaFiltrada = personaList.stream()
                        .filter(lp->!lp.getName().startsWith("A"))
                        .toList();
                for (Person person: listaFiltrada){
                    System.out.println("Name: " +  person.getName() + " Town: " + person.getTown() + " Age: " + person.getAge());
                }

        }

    //Filtrado C
       public void primerElementoMadrid(List<Person>personaList){
           Optional<Person> elementoMadrid = personaList.stream()
                   .filter(em -> em.getTown().equals("Madrid"))
                   .findFirst();

           // Optional is returned.
           if (elementoMadrid.isPresent()) {
               System.out.println(elementoMadrid.get());
           }
           // si el stream esta vacio, devolvemos madrid
           else {
               System.out.println("No hay ninguna persona que viva en Madrid");
           }
       }

        // Filtrado D
        public void primerElementoBarcelona(List<Person>personaList){
            Optional<Person> elementoMadrid = personaList.stream()
                    .filter(em -> em.getTown().equals("Barcelona"))
                    .findFirst();

            // Optional is returned.
            if (elementoMadrid.isPresent()) {
                System.out.println(elementoMadrid.get());
            }
            // si el stream esta vacio, devolvemos madrid
            else {
                System.out.println("No hay ninguna persona que viva en Barcelona");
            }
        }


    }





