package com.example.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuarios.model.Rol;
import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.RoleRepository;
import com.example.usuarios.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //metodo para obtener todos los usuarios
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }
    //metodo para crear un usuario
    public Usuario crearUsuario(String username, String password, Long roleId){
        //verificar si el Rol existe
        Rol rol = roleRepository.findById(roleId)
        .orElseThrow(()-> new RuntimeException("Rol no encontrado ID:"+ roleId));

        //si puedo crear el usuario nuevo
        Usuario nuevo = new Usuario();
        nuevo.setUsername(username);
        nuevo.setPassword(password);
        nuevo.setRol(rol);
        return usuarioRepository.save(nuevo);

    }
}