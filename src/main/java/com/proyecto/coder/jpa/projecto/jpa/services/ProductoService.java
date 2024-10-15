package com.proyecto.coder.jpa.projecto.jpa.services;

import com.proyecto.coder.jpa.projecto.jpa.exception.ProductoNoEncontradoException;
import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll(); // Retorna todos los productos
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

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id)); // Manejo de excepción
    }
    

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto); // Guarda un nuevo producto
    }

    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id)
            .map(producto -> {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setPrecio(nuevoProducto.getPrecio());
                producto.setCantidad(nuevoProducto.getCantidad());
                return productoRepository.save(producto);
            })
            .orElseThrow(() -> new ProductoNoEncontradoException(id)); // Lanzar excepción personalizada
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id); // Elimina un producto por ID
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre); // Busca productos por nombre
    }
}
