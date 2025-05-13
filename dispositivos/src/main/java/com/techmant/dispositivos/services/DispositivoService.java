package com.techmant.dispositivos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmant.dispositivos.model.Dispositivo;
import com.techmant.dispositivos.repository.DispositivoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    // Obtener todos los dispositivos 
    public List<Dispositivo> getDispositivos(){
        return dispositivoRepository.findAll();
    }

    // Obtener un dispositivo por su ID
    public Dispositivo getDispositiboById(Long id){
        return dispositivoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado"));
    }

    // Guardar un dispositivo
    public Dispositivo saveDispositivo(Dispositivo dispositivo){
        return dispositivoRepository.save(dispositivo);
    }

    // Eliminar un dispositivo por su ID
    public void deleteDispositivo(Long id){
        dispositivoRepository.deleteById(id);
    }

    // Modificar un dispositivo por su ID
    public Dispositivo updateDipositivo(Long id, Dispositivo dispositivo){

        Dispositivo dispositivoExistente = dispositivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Dispositivo no encontrnado"));
        dispositivoExistente.setTipoDeDispositivo(dispositivo.getTipoDeDispositivo());
        dispositivoExistente.setMarca(dispositivo.getMarca());
        dispositivoExistente.setModelo(dispositivo.getModelo());
        dispositivoExistente.setNroSerie(dispositivo.getNroSerie());
        return dispositivoRepository.save(dispositivoExistente);
        

    }


}
