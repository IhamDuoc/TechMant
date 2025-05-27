package com.example.ticket.model;

import lombok.Data;

@Data
public class Usuario {
    
    private Long idUsuario;
    private String nombre;
    private String correo;
    private String password;

    private Long idRol; 
    private Long idEstado;

}
