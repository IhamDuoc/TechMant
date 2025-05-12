package com.example.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.model.Rol;
import com.example.usuario.model.Usuario;
import com.example.usuario.service.RoleService;
import com.example.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleService roleService;

    // Endpoint para consultar todos los roles
    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getRoles() {
        List<Rol> roles = roleService.obtenerRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    // Endpoint para consultar todos los usuarios
    @GetMapping("/Users")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("Users")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioId(id);
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping("/Users")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevo = usuarioService.saveUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/Users")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Endpoint para eliminar un usuario por ID
    @DeleteMapping("/Users")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    
}
