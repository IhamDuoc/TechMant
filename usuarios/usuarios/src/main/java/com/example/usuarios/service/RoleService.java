package com.example.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuarios.model.Rol;
import com.example.usuarios.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Rol> obtenerRoles(){
        return roleRepository.findAll();
    }

    public Rol obternerRolPorId(Long id){
        return roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Rol no encontrado ID:" + id));
    }
}
