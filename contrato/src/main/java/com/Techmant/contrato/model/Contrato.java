package com.Techmant.contrato.model;

import java.util.Date;

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
@Table(name="contratos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contrato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idContrato;

    @Column(name="fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Column(name="fecha_fin", nullable = false)
    private Date fechaFin;
    @Column(name="tipo_servicio", nullable = false)
    private String tipoServicio;
    @Column(name="id_usuario", nullable = false)
    private Long IdUsuario;


}
