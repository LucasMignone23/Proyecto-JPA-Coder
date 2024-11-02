package com.proyecto.coder.jpa.projecto.jpa.controller;

import com.proyecto.coder.jpa.projecto.jpa.dto.ComprobanteRequestDTO;
import com.proyecto.coder.jpa.projecto.jpa.dto.ComprobanteResponseDTO;
import com.proyecto.coder.jpa.projecto.jpa.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<ComprobanteResponseDTO> crearComprobante(@RequestBody ComprobanteRequestDTO request) {
        ComprobanteResponseDTO response = comprobanteService.crearComprobante(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ComprobanteResponseDTO>> obtenerComprobantes() {
        List<ComprobanteResponseDTO> comprobantes = comprobanteService.obtenerTodosLosComprobantes();
        return ResponseEntity.ok(comprobantes);
    }
}
