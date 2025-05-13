package com.techmant.dispositivos.model;

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
@Table(name="dispositivos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_de_dispositivo",nullable = false)
    private String tipoDeDispositivo;

    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;

    @Column(name = "nro_serie" ,nullable = false)
    private String nroSerie;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;


}
