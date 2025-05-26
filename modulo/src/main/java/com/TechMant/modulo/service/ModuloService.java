package com.TechMant.modulo.service;

import com.TechMant.modulo.model.Modulo;
import com.TechMant.modulo.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> findAll() {
        return moduloRepository.findAll();
    }

    public Modulo findById(Long id) {
        return moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado"));
    }

    public Modulo createModulo(Modulo modulo) {
        if(modulo.getNombreModulo() == null || modulo.getNombreModulo().isEmpty()) {
            throw new IllegalArgumentException("El nombre del módulo no puede estar vacío");
        }
        return moduloRepository.save(modulo);
    }

    public Modulo updateModulo(Long id, Modulo moduloActualizado) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado"));

        if(moduloActualizado.getNombreModulo() == null || 
           moduloActualizado.getNombreModulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del módulo no puede estar vacío");
        }

        modulo.setNombreModulo(moduloActualizado.getNombreModulo());
        return moduloRepository.save(modulo);
    }

    public void deleteById(Long id) {
        moduloRepository.deleteById(id);
    }
}