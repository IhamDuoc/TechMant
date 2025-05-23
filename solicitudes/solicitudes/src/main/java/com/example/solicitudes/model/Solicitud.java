package com.example.solicitudes.model;



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
@Table(name = "Solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Asegúrate de definir un identificador
    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_solicitud; // Fecha de la solicitud

    @Column(nullable = true) // Puede ser nulo
    private String comentario; // Comentarios adicionales
    
    @Column(nullable = false)
    private String total; // Total de la solicitud
}
