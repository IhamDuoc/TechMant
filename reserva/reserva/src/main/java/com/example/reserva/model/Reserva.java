package com.example.reserva.model;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Reserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String fechaReserva;
    
    @Column(nullable = false)
    private String comentario;
    
    
    @Column(nullable = false)
    
    private int calificacion;
}
