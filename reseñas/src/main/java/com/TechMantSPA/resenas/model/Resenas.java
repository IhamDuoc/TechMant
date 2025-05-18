package com.TechMantSPA.resenas.model;

import java.util.Date;

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
    
    @Column(name = "fecha_resena")
    private Date fechaResena;
    
    @Column(name = "comentario")
    private String comentario;
    
    @Column(name = "calificacion")
    private int calificacion;
    
    @Column(name = "usuario_id_rol")
    private Long UsuarioIdRol;
    
    @Column(name = "servicio_id_servicio")
    private Long ServicioIdServicio;
    
}
