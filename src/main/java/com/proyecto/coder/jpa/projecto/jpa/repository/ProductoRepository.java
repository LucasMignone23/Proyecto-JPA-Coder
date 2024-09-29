package com.proyecto.coder.jpa.projecto.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.coder.jpa.projecto.jpa.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findAllByOrderByPrecioAsc(); // Para filtrar por precio ascendente
    List<Producto> findAllByOrderByPrecioDesc(); // Para filtrar por precio descendente
    List<Producto> findAllByOrderByNombreAsc(); // Para ordenar alfabéticamente
}