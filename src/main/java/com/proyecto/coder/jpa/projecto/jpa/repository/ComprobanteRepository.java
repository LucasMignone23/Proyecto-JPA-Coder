package com.proyecto.coder.jpa.projecto.jpa.repository;

import com.proyecto.coder.jpa.projecto.jpa.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
} 