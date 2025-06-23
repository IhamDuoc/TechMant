package com.example.solicitudes.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud; // Asegúrate de definir un identificador
    
    @Column(nullable = false)
    private Date fecha_solicitud; //DD/MM/AAAA

    @Column(nullable = true) 
    private String comentario; // Comentarios adicionales
    
    @Column(nullable = false)
    private String total; // Total de la solicitud
}