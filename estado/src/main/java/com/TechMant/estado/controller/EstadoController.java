package com.TechMant.estado.controller;

import com.TechMant.estado.model.Estado;
import com.TechMant.estado.service.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;


    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        return ResponseEntity.ok(estadoService.getAllEstados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.getEstadoById(id));
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        return new ResponseEntity<>(estadoService.createEstado(estado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Long id, @RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.updateEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
        estadoService.deleteEstado(id);
        return ResponseEntity.noContent().build();
    }
}