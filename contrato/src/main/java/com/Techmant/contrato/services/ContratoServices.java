package com.Techmant.contrato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techmant.contrato.model.Contrato;
import com.Techmant.contrato.repository.ContratoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContratoServices {

    @Autowired
    private ContratoRepository contratoRepository;

    // Método para traer todos los contratos
    public List<Contrato> getContratos(){
        return contratoRepository.findAll();
    }

    // Método para traer un contrato por su id
    public Contrato getContratoById(Long id){
        return contratoRepository.findById(id).orElse(null);
    }

    // Método para crear un contrato
    public Contrato createContrato(Contrato contrato){
        return contratoRepository.save(contrato);
    }

    // Método para actualizar un contrato
    public Contrato updateContrato(Long id, Contrato contrato){
        Contrato contratoExistente = contratoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        if(contrato.getFechaFin() != null && contrato.getFechaFin().before(contratoExistente.getFechaInicio())){
            throw new RuntimeException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }

        contratoExistente.setFechaFin(contrato.getFechaFin());
        contratoExistente.setTipoServicio(contrato.getTipoServicio());
        return contratoRepository.save(contratoExistente);
    }


}
