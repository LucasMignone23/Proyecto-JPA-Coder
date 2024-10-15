package com.proyecto.coder.jpa.projecto.jpa.services;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.repository.ProductoRepository;
import com.proyecto.coder.jpa.projecto.jpa.exception.ProductoNoEncontradoException;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private final ProductoRepository productoRepository;

    public FacturaService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public String realizarFacturacion(Long id, int cantidadSolicitada) {
        // Busca el producto por su ID, si no lo encuentra lanza la excepción
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        // Verifica si hay suficiente stock
        if (producto.getCantidad() < cantidadSolicitada) {
            return "Error: No hay suficiente stock para completar la venta.";
        }

        // Actualiza la cantidad de stock y guarda los cambios
        producto.setCantidad(producto.getCantidad() - cantidadSolicitada);
        productoRepository.save(producto);

        // Devuelve el total a pagar
        return "Facturación exitosa. Total a pagar: " + (producto.getPrecio() * cantidadSolicitada);
    }
}
