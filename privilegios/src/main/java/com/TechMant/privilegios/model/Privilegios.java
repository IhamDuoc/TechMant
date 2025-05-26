package com.TechMant.privilegios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "privilegios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilegios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilegio")
    private Long idPrivilegio;
    @Column(name = "id_rol", nullable = false)
    private Long idRol;
    @Column(name = "id_estado" , nullable = false)
    private Long idEstado;
    @Column(name = "id_modulo" , nullable = false)
    private Long idModulo;
    @Column(name = "tipo_privilegio" , nullable = false)
    private String tipoPrivilegio;


}
