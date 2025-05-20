package com.TechMant.Solicitud.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_solicitud")
    private Long idSolicitud;
    @Column(name="fecha_solicitud")
    private Date fechaSolicitud;
    @Column
    private String comentario;
    @Column
    private int total;

    // TODO: relaciones con otra tabla


}
