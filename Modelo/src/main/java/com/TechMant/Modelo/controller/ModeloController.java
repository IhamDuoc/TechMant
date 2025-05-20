package com.TechMant.Modelo.controller;

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

import com.TechMant.Modelo.model.Modelo;
import com.TechMant.Modelo.services.ModeloServices;

@RestController
@RequestMapping("/api/v1/modelos")
public class ModeloController {

    @Autowired 
    private ModeloServices modeloServices;

    // ENDPOINT para obtener todos los modelos
    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos(){
        List<Modelo> modelos = modeloServices.getAllModelos();
        if(modelos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelos);
    }

    // ENDPOINT para obtener un modelo por id
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable Long id){
        Modelo modelo = modeloServices.getServicioById(id);
        if(modelo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelo);
    }

    //ENDPOINT para crear un modelo
    @PostMapping
    public ResponseEntity<Modelo> createModelo(@RequestBody Modelo modelo){
        try {
            Modelo nuevoModelo = modeloServices.createModelo(modelo);
            return ResponseEntity.ok(nuevoModelo);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    //ENDPOINT para poder actualizar un modelo
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable Long id ,@RequestBody Modelo modelo){
        try {
            Modelo modeloActualizado = modeloServices.updateModelo(id,modelo);
            return ResponseEntity.ok(modeloActualizado);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    //ENDPOINT para poder eliminar un modelo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id){
        try {
            modeloServices.deleteModelo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }


}
