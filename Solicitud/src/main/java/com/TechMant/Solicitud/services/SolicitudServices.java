package com.TechMant.Solicitud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.Solicitud.model.Solicitud;
import com.TechMant.Solicitud.repository.SolicitudRepository;

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

    // Método para actualizar una solicitud
    public Solicitud updateSolicitud(Long id, Solicitud solicitud){
        Solicitud soli = solicitudRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        soli.setComentario(solicitud.getComentario());
        soli.setTotal(solicitud.getTotal());
        return solicitudRepository.save(soli);
    }

    // Método para eliminar una solicitud
    public void deleteSolicitud(Long id){
        solicitudRepository.deleteById(id);
    }
}
