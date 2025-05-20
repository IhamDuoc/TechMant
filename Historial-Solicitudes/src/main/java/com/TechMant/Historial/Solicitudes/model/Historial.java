package com.TechMant.Historial.Solicitudes.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long idHistorial;
    @Column(name="fecha_historial")
    private Date fechaHistorial;
    @Column
    private String comentario;
    // Llaves foraneas
    @Column(name="id_solicitud")
    private Long idSolicitud;
    @Column(name="id_estado")
    private Long idEstado;
    @Column(name="id_rol")
    private Long idRol;
    
}
