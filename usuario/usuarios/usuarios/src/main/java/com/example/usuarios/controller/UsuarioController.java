package com.example.usuarios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.model.Rol;
import com.example.usuarios.model.Usuario;
import com.example.usuarios.service.RoleService;
import com.example.usuarios.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/Usuario")
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
    public ResponseEntity<?> crearUsuario(@RequestBody Map<String, Object> requestBody) {
    try {
        // Validar que los campos existan
        if (!requestBody.containsKey("username") || !requestBody.containsKey("password") || 
            !requestBody.containsKey("rolId") || 
            !requestBody.containsKey("correo")) {
            return ResponseEntity.badRequest().body("Faltan campos obligatorios: username, password, rolId, apellido o correo");
        }

        // Extraer valores
        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        Long rolId = Long.valueOf(requestBody.get("rolId").toString());  // Asegurando que no sea null
        
        String correo = (String) requestBody.get("correo");

        // Llamar al servicio
        Usuario nuevoUsuario = usuarioService.crearUsuario(username, correo, password, rolId);
        nuevoUsuario.setPassword(null);  // Opcional: ocultar contraseña en la respuesta

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);

    } catch (RuntimeException e) {
        // Manejo de errores: devolver un mensaje de error
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        // Manejo de excepciones generales
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
    }

}

}