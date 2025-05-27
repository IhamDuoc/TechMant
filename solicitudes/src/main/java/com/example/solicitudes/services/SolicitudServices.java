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

    //Crear una nueva solicitud
    public Solicitud crearSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    //Obtener todas las solicitudes
    public List<Solicitud> obtenerTodasSolicitudes() {
        return solicitudRepository.findAll();
    }

    //Buscar una solicitud por ID
    public Solicitud obtenerSolicitudPorId(Long id) {
        return solicitudRepository.findById(id).get();
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