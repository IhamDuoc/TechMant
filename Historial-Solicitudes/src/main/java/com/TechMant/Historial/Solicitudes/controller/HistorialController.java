package com.TechMant.Historial.Solicitudes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.Historial.Solicitudes.model.Historial;
import com.TechMant.Historial.Solicitudes.services.HistorialServices;

@RestController
@RequestMapping("/api/v1/historial")
public class HistorialController {

    @Autowired
    private HistorialServices historialServices;

    // ENDPOINT PARA TRAER TODOS LOS HISTORIALES
    @GetMapping
    public ResponseEntity<List<Historial>> getAllHistoriales(){
        List<Historial> historiales = historialServices.getAllHistoriales();
        if(historiales.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historiales);
    }

    // ENDPOINT PARA TRAER UN HISTORIAL POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Historial> getHistorialById(@PathVariable Long id){
        Historial historial = historialServices.getHistorialById(id);
        if(historial == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(historial);
    }

    //ENDPOINT PARA CREAR UN HISTORIAL
    @PostMapping
    public ResponseEntity<Historial> createHistorial(@RequestBody Historial historial){
        try {
            Historial historialCreado = historialServices.createHistorial(historial);
            return ResponseEntity.ok(historialCreado);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }
}
