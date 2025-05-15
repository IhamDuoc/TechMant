package com.example.reserva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reserva.model.Reserva;
import com.example.reserva.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository; // Inyección del repositorio

    // Método para obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Método para crear una nueva reserva
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Método para obtener una reserva por ID
    // utilizando métodos de Optional, como isPresent() o get(), lo que mejora la legibilidad
    // y la seguridad del código.
    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    // Método para actualizar una reserva existente
    public Reserva updateReserva(Long id, Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setFechaReserva(reservaDetails.getFechaReserva());
        reserva.setComentario(reservaDetails.getComentario());
        reserva.setCalificacion(reservaDetails.getCalificacion());
        return reservaRepository.save(reserva);
    }

    // Método para eliminar una reserva
    public void deleteReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reservaRepository.delete(reserva);
    }
}

