package com.TechMant.privilegios.controller;


import com.TechMant.privilegios.client.RolServiceClient;
import com.TechMant.privilegios.model.Privilegios;
import com.TechMant.privilegios.service.PrivilegiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/privilegios")
public class PrivilegiosController {

    @Autowired
    private PrivilegiosService privilegiosService;

    @Autowired
    private RolServiceClient rolServiceClient;

    @GetMapping
    public ResponseEntity<List<Privilegios>> getAll() {
        return ResponseEntity.ok(privilegiosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privilegios> getById(@PathVariable Long id) {
        Privilegios privilegio = privilegiosService.findById(id);
        if(privilegio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(privilegio);
    }

    @PostMapping
public ResponseEntity<Privilegios> create(@RequestBody Privilegios privilegio) {
    try {
        return ResponseEntity.ok(privilegiosService.createPrivilegio(privilegio));
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }
}
@PutMapping("/{id}")
public ResponseEntity<Privilegios> updateTipoPrivilegio(
        @PathVariable Long id,
        @RequestBody Privilegios privilegioActualizado) {
    
    Privilegios updated = privilegiosService.updateTipoPrivilegio(id, privilegioActualizado);
    return ResponseEntity.ok(updated);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Privilegios privilegio = privilegiosService.findById(id);
        if(privilegio == null) {
            return ResponseEntity.notFound().build();
        }
        privilegiosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}