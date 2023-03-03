package com.example.examenJpaSergioCastillo.demo;

import com.example.examenJpaSergioCastillo.demo.cabeceraFra.domain.CabeceraFra;
import com.example.examenJpaSergioCastillo.demo.cabeceraFra.repository.CabeceraFraRepository;
import com.example.examenJpaSergioCastillo.demo.cliente.domain.Cliente;
import com.example.examenJpaSergioCastillo.demo.cliente.repository.ClienteRepository;
import com.example.examenJpaSergioCastillo.demo.lineasFra.domain.LineaFra;
import com.example.examenJpaSergioCastillo.demo.lineasFra.repository.LineaFraRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(Application.class, args);

		//Añadimos Cliente
		ClienteRepository clienteRepository =
				configurableApplicationContext.getBean(ClienteRepository.class);
		Cliente cliente1 = new Cliente( "steve");
		clienteRepository.save(cliente1);

		//Añadimos Factura
		CabeceraFraRepository cabeceraFraRepository =
				configurableApplicationContext.getBean(CabeceraFraRepository.class);
		CabeceraFra factura1 = new CabeceraFra(20, cliente1);
		cabeceraFraRepository.save(factura1);

		//Linea de Factura
		LineaFraRepository lineaFraRepository =
				configurableApplicationContext.getBean(LineaFraRepository.class);
		//creamos dos objetos de tipo Linea asociados a la factura 1
		LineaFra lineaFra1 = new LineaFra("Camisa", 4, 20.5, factura1);
		LineaFra lineaFra2 = new LineaFra("Jersey", 10, 30.1, factura1);
		//Creamos una lista de lineas para poder hacer un solo save
		List<LineaFra> lineasFra = Arrays.asList(lineaFra1, lineaFra2);
		//Insertamos las dos lineas de facturas
		lineaFraRepository.saveAll(lineasFra);


	}



}
