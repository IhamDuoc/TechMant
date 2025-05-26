package com.TechMant.privilegios.service;

import com.TechMant.privilegios.model.Privilegios;
import com.TechMant.privilegios.repository.PrivilegiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegiosService {

    @Autowired
    private PrivilegiosRepository privilegiosRepository;

    public List<Privilegios> findAll() {
        return privilegiosRepository.findAll();
    }

    public Privilegios findById(Long id) {
        return privilegiosRepository.findById(id).orElseThrow(() -> new RuntimeException("Privilegio no encontrado"));
    }

    public Privilegios createPrivilegio(Privilegios privilegio) {
        if(privilegio.getTipoPrivilegio() == null || privilegio.getTipoPrivilegio().isEmpty()) {
            throw new IllegalArgumentException("El tipo de privilegio no puede estar vacío");
        }
        return privilegiosRepository.save(privilegio);
    }

    public Privilegios updateTipoPrivilegio(Long id, Privilegios privilegioActualizado) {
        Privilegios privilegio = privilegiosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Privilegio no encontrado"));
        
        if(privilegioActualizado.getTipoPrivilegio() == null || 
           privilegioActualizado.getTipoPrivilegio().trim().isEmpty()) {
            throw new IllegalArgumentException("tipoPrivilegio no puede estar vacío");
        }
        
        privilegio.setTipoPrivilegio(privilegioActualizado.getTipoPrivilegio());
        return privilegiosRepository.save(privilegio);
    }

    public void deleteById(Long id) {
        privilegiosRepository.deleteById(id);
    }
}