package com.TechMant.Solicitud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMant.Solicitud.model.Solicitud;
@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long>{

}
