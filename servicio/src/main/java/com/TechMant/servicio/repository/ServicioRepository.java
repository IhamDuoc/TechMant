package com.TechMant.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMant.servicio.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
