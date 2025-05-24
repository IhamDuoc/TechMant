package com.example.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket.model.Ticket;
import com.example.ticket.services.TicketService;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

     // Crear un nuevo ticket
    @PostMapping
    public ResponseEntity<Ticket> crearTicket(@RequestBody Ticket ticket) {
        Ticket nuevo = ticketService.crearTicket(ticket);
        return ResponseEntity.ok(nuevo);
    }

    // Obtener todos los tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> obtenerTodosLosTickets() {
        return ResponseEntity.ok(ticketService.obtenerTodosLosTickets());
    }

    // Obtener un ticket por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicketPorId(@PathVariable Long id) {
        Ticket ticket = ticketService.obtenerTicketPorId(id); // Lanza excepción si no existe
        return ResponseEntity.ok(ticket);
    }

    // Actualizar un ticket por ID
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizarTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket actualizado = ticketService.actualizarTicket(id, ticket); // Lanza excepción si no existe
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un ticket por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id); // Lanza excepción si no existe
        return ResponseEntity.ok("Ticket con ID " + id + " eliminado correctamente.");
    }
}
