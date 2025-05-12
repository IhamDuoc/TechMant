package com.example.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.model.Rol;
import com.example.usuarios.model.Usuario;
import com.example.usuarios.service.RoleService;
import com.example.usuarios.service.UsuarioService;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RoleService roleService;

    //endpoint para consultar los roles
    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getRoles(){
        List<Rol> roles = roleService.obtenerRoles();
        //verifico si la lista quedo vacía
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }
    //endpoint para consultar los usuarios
    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> users = usuarioService.obtenerUsuarios();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    //endpoint para crea un usuario nuevo
    @PostMapping("/users")
    public ResponseEntity<?> crearUsuario(@RequestParam String username, @RequestParam String password, @RequestParam Long roleId){
        try {
            //intentamos crear el  usuario
            Usuario nuevo = usuarioService.crearUsuario(username, password, roleId);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            // Si no se crea capturo el string del error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}

    
    


