package com.TechMant.respuesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TechMant.respuesta.model.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}