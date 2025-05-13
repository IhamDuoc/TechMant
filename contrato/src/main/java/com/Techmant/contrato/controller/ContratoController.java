package com.Techmant.contrato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Techmant.contrato.model.Contrato;
import com.Techmant.contrato.services.ContratoServices;

@RestController
@RequestMapping("/api/v1/contratos")
public class ContratoController {

    @Autowired
    private ContratoServices contratoServices;

    // Endpoint para traer todos los contratos
    @GetMapping
    public ResponseEntity<List<Contrato>> getAllContratos() {
        List<Contrato> contratos = contratoServices.getContratos();
        if(contratos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(contratos);
        }
    }

    // Endpoint para traer un contrato por id
    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getContratoById(@PathVariable Long id){
        Contrato contrato = contratoServices.getContratoById(id);
        if(contrato == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(contrato);
        }
    }

    // Endpoint para crear un contrato
    @PostMapping
    public ResponseEntity<Contrato> createContrato(@RequestBody Contrato contrato){
        try {
            Contrato nuevoContrato = contratoServices.createContrato(contrato);
            return ResponseEntity.status(201).body(nuevoContrato);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para actualizar un contrato
    @PutMapping("/{id}")
    public ResponseEntity<Contrato> updateContrato(@PathVariable Long id, @RequestBody Contrato contrato){
        try {
            Contrato contratoActualizado = contratoServices.updateContrato(id, contrato);
            return ResponseEntity.ok(contratoActualizado);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("fecha")) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
