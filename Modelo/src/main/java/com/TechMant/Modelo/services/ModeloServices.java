package com.TechMant.Modelo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.Modelo.model.Modelo;
import com.TechMant.Modelo.repository.ModeloRepository;

@Service
public class ModeloServices {

    @Autowired
    private ModeloRepository modeloRepository;

    // Método para obtener todos los modelos
    public List<Modelo> getAllModelos(){
        return modeloRepository.findAll();
    }

    // Método para obtener un modelo por su ID
    public Modelo getServicioById(Long id){
        return modeloRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
    }

    // Método para crear un nuevo modelo
    public Modelo createModelo(Modelo modelo){
        return modeloRepository.save(modelo);
    }

    // Método para actualizar un modelo existente
    public Modelo updateModelo(Long id, Modelo modelo){
        Modelo modeloExistente = modeloRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
        modeloExistente.setNombreModelo(modelo.getNombreModelo());
        return modeloRepository.save(modeloExistente);
    }

    // Método para eliminar un modelo
    public void deleteModelo(Long id){
        modeloRepository.deleteById(id);
    }
}
