package com.TechMantSPA.equipos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMantSPA.equipos.model.Equipos;
import com.TechMantSPA.equipos.repository.EquiposRepository;

@Service
public class EquipoServices {

    @Autowired
    private EquiposRepository equiposRepository;


    // Método para obtener todos los equios
    public List<Equipos> getAllEquipos(){
        return equiposRepository.findAll();
    }

    // Método para obtener un equipo por su ID
    public Equipos getEquipoById(Long id){
        return equiposRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    // Método para crear un equipo
    public Equipos createEquipo(Equipos equipo){
        return equiposRepository.save(equipo);
    }

    // Método para actualizar un equipo
    public Equipos updateEquipo(Long id, Equipos equipo){
        Equipos equipoExistente = equiposRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoExistente.setTipoDeDispositivo(equipo.getTipoDeDispositivo());
        equipoExistente.setMarca(equipo.getMarca());
        equipoExistente.setNroSerie(equipo.getNroSerie());
        return equiposRepository.save(equipoExistente);
    }

    // Método para eliminar un equipo
    public void deleteEquipo(Long id){
        equiposRepository.deleteById(id);
    }


}
