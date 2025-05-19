package com.TechMantSPA.equipos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;
    @Column(name="tipo_de_dispositivo")
    private String TipoDeDispositivo;
    @Column
    private String marca;
    @Column(name="nro_serie")
    private String nroSerie;
    @Column
    private String descripcion;
    @Column(name="id_usuario")
    private Long UsuarioIdRol;
    @Column(name="id_tipo")
    private Long TipoIdTipo;

}
