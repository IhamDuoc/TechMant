package com.TechMant.Modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMant.Modelo.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}
