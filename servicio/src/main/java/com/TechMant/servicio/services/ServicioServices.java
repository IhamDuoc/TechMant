package com.TechMant.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.servicio.model.Servicio;
import com.TechMant.servicio.repository.ServicioRepository;

@Service
public class ServicioServices {

    @Autowired
    private ServicioRepository servicioRepository;

    // Método para obtener todos los servicios
    public List<Servicio> getAllServicios(){
        return servicioRepository.findAll();
    }

    // Método para obtener un servicio por su ID
    public Servicio getServicioById(Long id){
        return servicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    // Método para crear un nuevo servicio
    public Servicio createServicio(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    // Método para actualizar un servicio existente
    public Servicio updateServicio(Long id, Servicio servicio){
        Servicio servicioExistente = servicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        servicioExistente.setNombreServicio(servicio.getNombreServicio());
        servicioExistente.setDescripcion(servicio.getDescripcion());
        servicioExistente.setPrecio(servicio.getPrecio());
        return servicioRepository.save(servicioExistente);
    }

    // Método para eliminar un servicio por su ID
    public void deleteServicio(Long id){
        servicioRepository.deleteById(id);
    }
}
