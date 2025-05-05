package com.TechMant.reporte.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoReparacion {
    PENDIENTE("Pendiente"),
    EN_PROCESO("En proceso"),
    FINALIZADO("Finalizado");

    private final String estado;
    

    
}
