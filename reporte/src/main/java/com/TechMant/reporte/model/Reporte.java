package com.TechMant.reporte.model;

import java.util.Date;

import com.TechMant.reporte.model.enums.EstadoReparacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date fechaCreacion;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 255)
    private String descripcionProblema;

    @Column()
    private String diagnostico;

    @Column()
    private String componentesUsados;

    @Column()
    private String observaciones;

    @Enumerated(EnumType.STRING)
    @Column(name="estado", nullable = false)
    private EstadoReparacion estado; 

    @Column(nullable = false, length = 50)
    private String firmaTecnico;

    
    


}
