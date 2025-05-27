package com.example.solicitudes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solicitudes.model.Solicitud;
import com.example.solicitudes.services.SolicitudServices;
@RestController
@RequestMapping("/api/v1/solicitudes")
public class solicitudController {
    @Autowired
    private SolicitudServices solicitudServices;

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAllSolicitudes(){
        List<Solicitud> solicitudes = solicitudServices.getAllSolicitudes();
        if(solicitudes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(solicitudes);
    }

    // ENDPOINT PARA TRAER UNA SOLICITUD POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable Long id){
        Solicitud solicitud = solicitudServices.getSolicitudById(id);
        if(solicitud == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(solicitud);
    }

    @PostMapping
    public ResponseEntity<Solicitud> createSolicitud(@RequestBody Solicitud solicitud){
        try {
            Solicitud solicitudCreada = solicitudServices.createSolicitud(solicitud);
            return ResponseEntity.ok(solicitudCreada);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }

    }

    // Actualizar una solicitud
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        Solicitud solicitudActualizada = solicitudServices.actualizarSolicitud(id, solicitud);
        if (solicitudActualizada != null) {
            return ResponseEntity.ok(solicitudActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una solicitud
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudServices.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}
