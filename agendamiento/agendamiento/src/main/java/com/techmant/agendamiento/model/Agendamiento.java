package com.techmant.agendamiento.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "Agenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamiento;

    @Column(name = "estado", nullable = false )
    private String estado;

    //formato de fecha 
    @Column(name = "fechaCita", nullable = false)
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date fechaCita; 

    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    //llaves foraneas
    @Column(name = "equipo_id_equipo", nullable = false)
    private Long dispositivoId;

}
