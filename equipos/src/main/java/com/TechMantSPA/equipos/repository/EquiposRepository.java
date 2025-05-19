package com.TechMantSPA.equipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMantSPA.equipos.model.Equipos;

@Repository
public interface EquiposRepository extends JpaRepository<Equipos, Long> {

}
