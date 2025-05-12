package com.example.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuario.model.Usuario;
import com.example.usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // Obtener todos los usuarios
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Guardar un nuevo usuario
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario //revicion para el iham
    public Usuario updateUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = getUsuarioId(id);
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido(usuarioActualizado.getApellido());
        usuarioExistente.setClave(usuarioActualizado.getClave());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        return usuarioRepository.save(usuarioExistente);
    }

    // Eliminar un usuario
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
