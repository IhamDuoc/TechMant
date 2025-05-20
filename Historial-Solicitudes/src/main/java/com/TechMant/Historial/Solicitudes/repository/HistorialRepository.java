package com.TechMant.Historial.Solicitudes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMant.Historial.Solicitudes.model.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long>{

}
