package com.TechMant.Historial.Solicitudes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.Historial.Solicitudes.model.Historial;
import com.TechMant.Historial.Solicitudes.repository.HistorialRepository;

@Service
public class HistorialServices {

    @Autowired
    private HistorialRepository historialRepository;

    // Método para traer todos los historiales
    public List<Historial> getAllHistoriales(){
        List<Historial> historiales = historialRepository.findAll();
        if(historiales.isEmpty()){
            return null;
        }else{
            return historiales;
        }
    }

    // Método para traer un historial por id
    public Historial getHistorialById(Long id){
        return historialRepository.findById(id).orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }

    // Método para crear un historial
    public Historial createHistorial(Historial historial){
        return historialRepository.save(historial);
    }



}
