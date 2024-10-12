package com.proyecto.coder.jpa.projecto.jpa.services;

import org.springframework.stereotype.Service;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository; // Repositorio de productos

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository; // Inyección de dependencias
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll(); // Devuelve todos los productos
    }

    public List<Producto> filtrarPorPrecioAsc() {
        return productoRepository.findAllByOrderByPrecioAsc(); // Filtra por precio ascendente
    }

    public List<Producto> filtrarPorPrecioDesc() {
        return productoRepository.findAllByOrderByPrecioDesc(); // Filtra por precio descendente
    }

    public List<Producto> filtrarPorNombreAsc() {
        return productoRepository.findAllByOrderByNombreAsc(); // Filtra alfabéticamente
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto); // Persiste el producto
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id); // Elimina el producto por ID
    }

    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id) // Actualiza el producto
            .map(producto -> {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setPrecio(nuevoProducto.getPrecio());
                producto.setCantidad(nuevoProducto.getCantidad());
                return productoRepository.save(producto);
            })
            .orElseThrow(() -> new RuntimeException("Producto no encontrado")); // Manejo de errores
    }

    // Nuevo método para facturación
    public String realizarFacturacion(Long id, int cantidadSolicitada) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        if (producto.getCantidad() < cantidadSolicitada) {
            return "Error: No hay suficiente stock para completar la venta."; // Mensaje de error
        }

        producto.setCantidad(producto.getCantidad() - cantidadSolicitada); // Descuenta del stock
        productoRepository.save(producto); // Actualiza el producto en la base de datos
        return "Facturación exitosa. Total a pagar: " + (producto.getPrecio() * cantidadSolicitada); // Mensaje de éxito
    }
}
