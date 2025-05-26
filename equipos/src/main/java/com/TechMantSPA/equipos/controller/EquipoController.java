package com.TechMantSPA.equipos.controller;

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

import com.TechMantSPA.equipos.model.Equipos;
import com.TechMantSPA.equipos.services.EquipoServices;

@RestController
@RequestMapping("api/v1/equipos")
public class EquipoController {

    @Autowired
    private EquipoServices equipoServices;

    // ENDPOINT para traer todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipos>> getAll(){
        List<Equipos> equipos = equipoServices.getAllEquipos();
        if(equipos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipos);
    }

    // ENDPOINT para traer un equipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipos> getById(@PathVariable Long id){
        Equipos equipo = equipoServices.getEquipoById(id);
        if(equipo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipo);
    }

    // ENDPOINT para crear un equipo
    @PostMapping
    public ResponseEntity<Equipos> createEquipo(@RequestBody Equipos equipo){
        try {
            Equipos nuevoEquipo = equipoServices.createEquipo(equipo);
            return ResponseEntity.ok(nuevoEquipo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // ENDPOINT para actualizar un equipo
    @PutMapping("/{id}")
    public ResponseEntity<Equipos> updateEquipo(@PathVariable Long id, @RequestBody Equipos equipo){
        Equipos equipoActualizado = equipoServices.updateEquipo(id, equipo);
        if(equipoActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipoActualizado);
    }

    // ENDPOINT para eliminar un equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id){
        equipoServices.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }

}
