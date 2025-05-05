package com.TechMant.reporte.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.reporte.model.Reporte;
import com.TechMant.reporte.service.ReporteService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {
    
    @Autowired
    private ReporteService reporteService;
    
    // URL para traer todos los reportes
    @GetMapping
    public ResponseEntity<List<Reporte>> listaReportes(){
        List<Reporte> reportes = reporteService.listaReportes();
        if(reportes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }

    // URL para traer reporte por id
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> buscarReporte(@PathVariable Long id){
        Reporte reporte = reporteService.buscarReporte(id);
        return ResponseEntity.ok(reporte); 
    }

    // URL para agregar un reporte
    @PostMapping
    public ResponseEntity<?> agregarReporte(@RequestBody Reporte reporte){
        try {
            // Validacion manual
            if(reporte.getFechaCreacion() == null){
                return ResponseEntity.badRequest().body("La fecha es obligatoria");
            }
            if(reporte.getTipo() == null){
                return ResponseEntity.badRequest().body("El tipo es obligatorio");

            }
            if(reporte.getEstado() == null){
                return ResponseEntity.badRequest().body("El estado es obligatorio");
            }
            Reporte reporteGuardado = reporteService.agregarReporte(reporte);
            return ResponseEntity.ok(reporteGuardado);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.internalServerError().body("Error al procesar el reporte");
        }
    }


    // 
}
