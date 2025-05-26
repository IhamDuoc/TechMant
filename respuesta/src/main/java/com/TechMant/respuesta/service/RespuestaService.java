package com.TechMant.respuesta.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.respuesta.model.Respuesta;
import com.TechMant.respuesta.repository.RespuestaRepository;

@Service
public class RespuestaService {

    @Autowired
    private  RespuestaRepository respuestaRepository;

    
    public List<Respuesta> findAll() {
        return respuestaRepository.findAll();
    }

    public Respuesta getRespuestaById(Long id){
        return respuestaRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
    }

    public Respuesta save(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public void deleteById(Long id) {
        if (respuestaRepository.existsById(id)) {
            respuestaRepository.deleteById(id);
        }
    }

    public Respuesta updateRespuesta(Long id, Respuesta respuesta){
        Respuesta respuestaExistente = respuestaRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
        respuestaExistente.setComentario(respuesta.getComentario());;
        return respuestaRepository.save(respuestaExistente);
    }
}