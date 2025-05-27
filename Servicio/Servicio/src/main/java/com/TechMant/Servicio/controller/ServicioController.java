package com.TechMant.Servicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.Servicio.model.Servicio;
import com.TechMant.Servicio.service.ServicioService;

@RestController
@RequestMapping("api/v1/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    //Enpoint para obtener todos los servicios 
    @GetMapping
    public ResponseEntity<List<Servicio>> listarServicios() {
        List<Servicio> servicios = servicioService.obtenerServicios();
        //preguntar si vienen registros vacios o no 
        if(servicios.isEmpty()) {
            //si la lista esta vacia se pone el error 204 
            return ResponseEntity.noContent().build();
        }
        //si no esta vacia entonces nos los da :)
        return ResponseEntity.ok(servicios);
    }



    //Endpoint para buscar un servicio por su id 
    @GetMapping("{/id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable Long id) {
        Servicio servicio = servicioService.obtenerServicioPorId(id);
        if(servicio == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(servicio);
        }
    }


    //Endpoint para crear un servicio nuevo 
    @PostMapping
    public ResponseEntity<Servicio> agregarServico(@RequestBody Servicio servicio) {
        try {
            Servicio nuevoServicio = servicioService.agregarServicio(servicio);
            return ResponseEntity.ok(nuevoServicio);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
