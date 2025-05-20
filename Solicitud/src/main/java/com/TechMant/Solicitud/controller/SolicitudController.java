package com.TechMant.Solicitud.controller;

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

import com.TechMant.Solicitud.model.Solicitud;
import com.TechMant.Solicitud.services.SolicitudServices;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudServices solicitudServices;

    // ENDPOINT PARA TRAER TODOS LAS SOLICITUDES
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

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> updateSolicitud(@PathVariable Long id, @RequestBody Solicitud solicitud){
        try {
            Solicitud solicitudActualizada = solicitudServices.updateSolicitud(id, solicitud);
            return ResponseEntity.ok(solicitudActualizada);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Solicitud> deleteSolicitud(@PathVariable Long id){
        try {
            solicitudServices.deleteSolicitud(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }
}
