package com.proyecto.coder.jpa.projecto.jpa.controller;

import com.proyecto.coder.jpa.projecto.jpa.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/{productoId}")
    public ResponseEntity<String> realizarFacturacion(@PathVariable Long productoId, @RequestParam int cantidad) {
        String resultado = facturaService.realizarFacturacion(productoId, cantidad);
        return ResponseEntity.ok(resultado);
    }
}
