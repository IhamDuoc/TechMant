package com.techmant.dispositivos.controller;

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

import com.techmant.dispositivos.model.Dispositivo;
import com.techmant.dispositivos.services.DispositivoService;

@RestController
@RequestMapping("/api/v1/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    // Endpoint para obtener todos los dispositivos
    @GetMapping
    public ResponseEntity<List<Dispositivo>> getAllDispositivos(){
        List<Dispositivo> dispositivos = dispositivoService.getDispositivos();
        if(dispositivos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(dispositivos);
        }
    }

    // Endpoint para obtener un dispositivo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id){
        Dispositivo dispositivo = dispositivoService.getDispositiboById(id);
        if(dispositivo == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(dispositivo);
        }
    }

    // Endpoint para crear un nuevo dispositivo
    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo){
        try {
            Dispositivo nuevoDispositivo = dispositivoService.saveDispositivo(dispositivo);
            return ResponseEntity.ok(nuevoDispositivo);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para actualizar un dispositivo por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo){
        try {
            Dispositivo dispositivoActualizado = dispositivoService.updateDipositivo(id, dispositivo);
            return ResponseEntity.ok(dispositivoActualizado);
        } catch (RuntimeException e) {
            
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            
            return ResponseEntity.badRequest().build();
        }
    }




    // Endpoint para eliminar un dispositivo por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id){
        Dispositivo dispositivo = dispositivoService.getDispositiboById(id);
        if(dispositivo == null){
            return ResponseEntity.notFound().build();
        }else{
            dispositivoService.deleteDispositivo(id);
            return ResponseEntity.noContent().build();
        }
    }




}
