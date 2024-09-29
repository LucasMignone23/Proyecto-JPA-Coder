package com.proyecto.coder.jpa.projecto.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.services.ProductoService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productoService.agregarProducto(new Producto("Joystick", 100, 10));
		for (Producto p : productoService.listarTodos()) {
			System.out.println(p);
		}
	}

}
