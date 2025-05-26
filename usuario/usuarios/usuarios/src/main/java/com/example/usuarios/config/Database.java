package com.example.usuarios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.usuarios.model.Rol;
import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.RoleRepository;
import com.example.usuarios.repository.UsuarioRepository;

@Configuration
public class Database {
    @Bean
      CommandLineRunner initDatabase(RoleRepository roleRepo, UsuarioRepository usuarioRepo) {
        return args -> {
            // Si no hay registros en las tablas, inserto los de defecto
            if (roleRepo.count() == 0 && usuarioRepo.count() == 0) {
                // Cargar los roles
                Rol admin = new Rol();
                admin.setNombre("Administrador");
                roleRepo.save(admin);

                Rol tecnico = new Rol(); // Cambiado a minuscula para seguir la convención
                tecnico.setNombre("Técnico"); // Establecer el nombre del rol
                roleRepo.save(tecnico);

                // Cargar los usuarios con todos los campos
                usuarioRepo.save(new Usuario(null, "Carlos", "123456789", "carlos@TechMantSPA", admin));
                usuarioRepo.save(new Usuario(null, "Laura", "987654321", "laura@TechMantSPA", tecnico));
                usuarioRepo.save(new Usuario(null, "Javier", "456789123", "javier@TechMantSPA", admin));
                usuarioRepo.save(new Usuario(null, "Ana", "321654987", "ana@TechMantSPA", tecnico));

                System.out.println("¡Listo! Los datos iniciales se han agregado");
            } else {
                System.out.println("Parece que ya hay datos. No se han agregado nuevos");
            }
        };
    }

}