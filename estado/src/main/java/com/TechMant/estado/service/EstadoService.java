package com.TechMant.estado.service;

import com.TechMant.estado.model.Estado;
import com.TechMant.estado.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;


    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    public Estado getEstadoById(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));
    }

    public Estado createEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado updateEstado(Long id, Estado estado) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con ID: " + id);
        }
        estado.setTipoEstado(estado.getTipoEstado());
        return estadoRepository.save(estado);
    }

    public void deleteEstado(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con ID: " + id);
        }
        estadoRepository.deleteById(id);
    }
}