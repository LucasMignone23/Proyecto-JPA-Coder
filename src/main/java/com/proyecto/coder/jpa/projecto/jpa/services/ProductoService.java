package com.proyecto.coder.jpa.projecto.jpa.services;

import org.springframework.stereotype.Service;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public List<Producto> filtrarPorPrecioAsc() {
        return productoRepository.findAllByOrderByPrecioAsc();
    }

    public List<Producto> filtrarPorPrecioDesc() {
        return productoRepository.findAllByOrderByPrecioDesc();
    }

    public List<Producto> filtrarPorNombreAsc() {
        return productoRepository.findAllByOrderByNombreAsc();
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto); // Este método asegura la persistencia del producto
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id)
            .map(producto -> {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setPrecio(nuevoProducto.getPrecio());
                producto.setCantidad(nuevoProducto.getCantidad());
                return productoRepository.save(producto);
            })
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
