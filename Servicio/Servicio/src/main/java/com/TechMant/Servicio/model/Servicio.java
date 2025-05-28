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
    
    @Column(name = "nombre_servicio", nullable = false)
    private String nombreServicio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private float precio;

    //llaves foraneas 
    @Column (name = "Categoria_id_categoria")
    private Long idCategoria; 

 
}
