package com.TechMant.servicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.servicio.model.Servicio;
import com.TechMant.servicio.services.ServicioServices;

@RestController
@RequestMapping("/api/v1/servicio")
public class ServicioController {

    @Autowired
    private ServicioServices servicioServices;

    // ENDPOINT para obtener todos los servicios
    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicios(){
        List<Servicio> servicios = servicioServices.getAllServicios();
        if(servicios.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(servicios);
        }
        
    }

    // ENDPOINT para obtener un servicio por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Long id){
        Servicio servicio = servicioServices.getServicioById(id);
        if(servicio == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(servicio);
        }
    }

    // ENDPOINT para crear un nuevo servicio
    @PostMapping()
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio){
        try {
            Servicio nuevoServicio = servicioServices.createServicio(servicio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoServicio);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // ENDPOINT para actualizar un servicio existente
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicio){
        try {
            Servicio servicioActualizado = servicioServices.updateServicio(id, servicio);
            return ResponseEntity.ok(servicioActualizado);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }

    // ENDPOINT para eliminar un servicio existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Servicio> deleteServicio(@PathVariable Long id){
        try {
            servicioServices.deleteServicio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }

}
