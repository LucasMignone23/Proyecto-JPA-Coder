package com.proyecto.coder.jpa.projecto.jpa.controller;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService; // Inyección de dependencias del servicio

    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos(); // Devuelve la lista de productos
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.agregarProducto(producto)); // Agrega un nuevo producto
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, nuevoProducto)); // Actualiza un producto existente
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id); // Elimina un producto por ID
        return ResponseEntity.noContent().build(); // Respuesta sin contenido
    }

    @PostMapping("/facturacion/{id}")
    public ResponseEntity<String> realizarFacturacion(@PathVariable Long id, @RequestParam int cantidad) {
        String resultado = productoService.realizarFacturacion(id, cantidad); // Llama al método de facturación
        return ResponseEntity.ok(resultado); // Devuelve el resultado de la facturación
    }
}
