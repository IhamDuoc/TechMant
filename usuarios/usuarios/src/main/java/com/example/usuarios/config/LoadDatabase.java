package com.example.usuarios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.usuarios.model.Rol;
import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.RoleRepository;
import com.example.usuarios.repository.UsuarioRepository;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepo, UsuarioRepository usuarioRepo){
        return args ->{
            //si no hay registros en las tablas inserto los de defecto
            if(roleRepo.count() == 0 && usuarioRepo.count() == 0){
                //cargar los roles
                Rol admin = new Rol();
                admin.setNombre("Administrador");
                roleRepo.save(admin);

                Rol cliente = new Rol();
                cliente.setNombre("Cliente");
                roleRepo.save(cliente);

                //cargar los usuarios
                usuarioRepo.save(new Usuario(null,"victor","12345",admin));
                usuarioRepo.save(new Usuario(null,"Joselito","12345",cliente));
                
            }
            else{
                System.out.println("Datos ya existen. No se cargaron nuevos datos");

            }
        };
    }
}
