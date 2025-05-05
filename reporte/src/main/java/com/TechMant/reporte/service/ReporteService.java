package com.TechMant.reporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.reporte.model.Reporte;
import com.TechMant.reporte.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private  ReporteRepository reporteRepository;


    // Funcion para traer todos los reportes
    public List<Reporte> listaReportes(){
        return reporteRepository.findAll();
    }

    // Funcion para traer un reporte por id
    public Reporte buscarReporte(Long id){
        return reporteRepository.findById(id).get();
    }


    // funcion para agrear un nuevo reporte
    public Reporte agregarReporte(Reporte reporte){
        return reporteRepository.save(reporte);
    }



    
}
