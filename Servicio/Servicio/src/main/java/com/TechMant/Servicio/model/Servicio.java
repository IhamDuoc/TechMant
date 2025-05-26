package com.TechMant.Servicio.model;

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
@Table(name = "Servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idServicio;
    
    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private float precio;

    //llaves foraneas 
    @Column (name = "id_categoria")
    private Long idCategoria; 


}
