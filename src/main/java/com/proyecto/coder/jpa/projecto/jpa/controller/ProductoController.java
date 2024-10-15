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
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos(); // Devuelve la lista de productos
    }

    @GetMapping("/{id}")
public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
    Producto producto = productoService.buscarPorId(id); // Método implementado en el servicio
    return ResponseEntity.ok(producto); // Devuelve el producto encontrado
}


    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.agregarProducto(producto)); // Agrega un nuevo producto
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, nuevoProducto)); // Actualiza un producto
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id); // Elimina un producto por ID
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.buscarPorNombre(nombre); // Buscar productos por nombre
        return ResponseEntity.ok(productos);
    }

    
}
