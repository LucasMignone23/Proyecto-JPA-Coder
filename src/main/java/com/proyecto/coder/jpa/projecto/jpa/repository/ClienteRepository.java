package com.proyecto.coder.jpa.projecto.jpa.repository;

import com.proyecto.coder.jpa.projecto.jpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNumeroDeCuit(String numeroDeCuit);
    Optional<Cliente> findByMail(String mail);
}
