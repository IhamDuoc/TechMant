package com.example.usuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true,length = 50)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    //identificamos la relacion: muchos usuarios pueden compartir un mismo rol
    @ManyToOne
    @JoinColumn(name = "rol_id")//nombre de la columna foranea
    @JsonIgnoreProperties("users")// ignorar el atributo users cuando serialicemos el rol
    private Rol rol;

}
