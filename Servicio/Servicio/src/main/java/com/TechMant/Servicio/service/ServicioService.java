package com.TechMant.Servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.Servicio.model.Servicio;
import com.TechMant.Servicio.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    //metodo para ver los servicios echos a los dispositivos 
    public List<Servicio> obtenerServicios() {
        return  servicioRepository.findAll();
    }

    //metodo para traer un servicio por su id :)
    public Servicio obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Lo sentimo servicio no disponible"));
    }

    //metodo para agregar un servicio
    public Servicio agregarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }


}
