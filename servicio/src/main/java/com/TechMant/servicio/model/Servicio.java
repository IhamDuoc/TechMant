package com.TechMant.servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;
    @Column(name="nombre_servicio")
    private String nombreServicio;
    @Column
    private String descripcion;
    @Column
    private int precio;
    @Column(name="id_categoria")
    private Long CategoriaIdCategoria;
}
