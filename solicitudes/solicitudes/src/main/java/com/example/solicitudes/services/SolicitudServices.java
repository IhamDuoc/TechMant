package com.example.solicitudes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.solicitudes.model.Solicitud;
import com.example.solicitudes.repository.SolicitudRepository;

@Service
public class SolicitudServices {
    @Autowired
    private SolicitudRepository solicitudRepository;

       // Método para traer todas las solicitudes
    public List<Solicitud> getAllSolicitudes(){
        return solicitudRepository.findAll();
    }

    // Método para traer una solicitud por ID
    public Solicitud getSolicitudById(Long id){
        return solicitudRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Solicitud no encontrado"));
    }

    // Método para crear una solicitud
    public Solicitud createSolicitud(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    // Actualizar una solicitud
    public Solicitud actualizarSolicitud(Long id, Solicitud solicitudActualizada) {
        if (solicitudRepository.existsById(id)) {
            solicitudActualizada.setId(id);
            return solicitudRepository.save(solicitudActualizada);
        }
        return null; 
    }

    // Eliminar una solicitud
    public void eliminarSolicitud(Long id) {
        if (solicitudRepository.existsById(id)) {
            solicitudRepository.deleteById(id);
        }
        
    }

}