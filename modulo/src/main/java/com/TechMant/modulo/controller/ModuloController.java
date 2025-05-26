package com.TechMant.modulo.controller;

import com.TechMant.modulo.model.Modulo;
import com.TechMant.modulo.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/modulo")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public ResponseEntity<List<Modulo>> getAll() {
        return ResponseEntity.ok(moduloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> getById(@PathVariable Long id) {
        Modulo modulo = moduloService.findById(id);
        if(modulo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modulo);
    }

    @PostMapping
    public ResponseEntity<Modulo> create(@RequestBody Modulo modulo) {
        try {
            return ResponseEntity.ok(moduloService.createModulo(modulo));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> updateModulo(
            @PathVariable Long id,
            @RequestBody Modulo moduloActualizado) {
        
        Modulo updated = moduloService.updateModulo(id, moduloActualizado);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Modulo modulo = moduloService.findById(id);
        if(modulo == null) {
            return ResponseEntity.notFound().build();
        }
        moduloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}