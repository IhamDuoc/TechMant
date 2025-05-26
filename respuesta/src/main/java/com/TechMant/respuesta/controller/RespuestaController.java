package com.TechMant.respuesta.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TechMant.respuesta.model.Respuesta;
import com.TechMant.respuesta.service.RespuestaService;

@RestController
@RequestMapping("/api/v1/respuesta")
public class RespuestaController {
    @Autowired
    private  RespuestaService respuestaService;

    

    @GetMapping
    public ResponseEntity<List<Respuesta>> getAllRespuestas() {
        return ResponseEntity.ok(respuestaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> getModeloById(@PathVariable Long id){
        Respuesta respuesta = respuestaService.getRespuestaById(id);
        if(respuesta == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuestaService.save(respuesta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> updateModelo(@PathVariable Long id ,@RequestBody Respuesta modelo){
        try {
            Respuesta modeloActualizado = respuestaService.updateRespuesta(id,modelo);
            return ResponseEntity.ok(modeloActualizado);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Long id){
        try {
            respuestaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }
}