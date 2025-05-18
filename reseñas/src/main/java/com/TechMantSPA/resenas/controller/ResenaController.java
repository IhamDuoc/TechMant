package com.TechMantSPA.resenas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TechMantSPA.resenas.model.Resenas;
import com.TechMantSPA.resenas.services.ResenaServices;

@Controller
@RequestMapping("/api/v1/resenas")
public class ResenaController {

    @Autowired
    private ResenaServices resenaServices;

    // ENDPOINT para traer todas las reseñas
    @GetMapping
    public ResponseEntity<List<Resenas>> findAll() {
        List<Resenas> resenas = resenaServices.findAll();
        if(resenas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }

    // ENDPOINT para traer una reseña por id
    @GetMapping("/{id}")
    public ResponseEntity<Resenas> findById(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Resenas resena = resenaServices.findById(id);
        if(resena == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resena);
    }

    // ENDPOINT para guardar una reseña 
    @PostMapping
    public ResponseEntity<Resenas> saveResena(@RequestBody Resenas res) {
        if(res == null) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            Resenas savedResena = resenaServices.saveResena(res);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedResena);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // ENDPOINT para actualizar una reseña
    @PutMapping("/{id}")
    public ResponseEntity<Resenas> updateResena(@PathVariable Long id, @RequestBody Resenas res) {
        if(id == null || res == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Resenas updatedResena = resenaServices.updateResena(id, res);
        if(updatedResena == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedResena);
    }

    // ENDPOINT para eliminar una reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Resenas resena = resenaServices.findById(id);
        if(resena == null) {
            return ResponseEntity.notFound().build();
        }
        
        resenaServices.deleteResena(id);
        return ResponseEntity.noContent().build();
    }

}
