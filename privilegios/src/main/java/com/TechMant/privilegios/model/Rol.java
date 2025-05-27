package com.TechMant.privilegios.model;

import lombok.Data;

@Data
public class Rol {
    private Long id;       // Nombre exacto al JSON ("idRol")
    private String nombreRol;
}
