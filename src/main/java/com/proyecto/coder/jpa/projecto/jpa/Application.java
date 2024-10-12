package com.proyecto.coder.jpa.projecto.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.services.ProductoService;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProductoService productoService; // Inyección de dependencias del servicio

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // Inicia la aplicación
    }

    @Override
    public void run(String... args) throws Exception {
        // Agregar un producto inicial
        productoService.agregarProducto(new Producto("Joystick", 100, 10));
        
        // Listar todos los productos
        System.out.println("Todos los productos:");
        List<Producto> productos = productoService.listarTodos();
        for (Producto p : productos) {
            System.out.println(p); // Imprime todos los productos en la consola
        }
        
        // Filtrar productos por precio ascendente
        System.out.println("\nProductos ordenados por precio ascendente:");
        List<Producto> productosPrecioAsc = productoService.filtrarPorPrecioAsc();
        for (Producto p : productosPrecioAsc) {
            System.out.println(p); // Imprime productos ordenados por precio ascendente
        }

        // Filtrar productos por precio descendente
        System.out.println("\nProductos ordenados por precio descendente:");
        List<Producto> productosPrecioDesc = productoService.filtrarPorPrecioDesc();
        for (Producto p : productosPrecioDesc) {
            System.out.println(p); // Imprime productos ordenados por precio descendente
        }

        // Filtrar productos por nombre ascendente
        System.out.println("\nProductos ordenados alfabéticamente por nombre:");
        List<Producto> productosNombreAsc = productoService.filtrarPorNombreAsc();
        for (Producto p : productosNombreAsc) {
            System.out.println(p); // Imprime productos ordenados alfabéticamente
        }
    }
}
