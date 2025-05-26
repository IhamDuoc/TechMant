package com.TechMantSPA.resenas.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "reseñas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Resenas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long idResena;
    
    @Column(name = "fecha_resena", nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date fechaResena;
    
    @Column(name = "comentario", nullable = false)
    private String comentario;
    
    @Column(name = "calificacion", nullable = false)
    private int calificacion;
    
    @Column(name = "usuario_id_rol", nullable = false)
    private Long UsuarioIdRol;
    
    @Column(name = "servicio_id_servicio", nullable = false)
    private Long ServicioIdServicio;
    
}
