package com.TechMant.respuesta.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuesta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;
    @Column(nullable = false)
    private String comentario;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaRespuesta;
    @Column(nullable = false)
    private String tipoRespuesta;
    @Column(nullable = false)
    private Long idTicket;
    @Column(nullable = false)
    private Long idEstado;

}
