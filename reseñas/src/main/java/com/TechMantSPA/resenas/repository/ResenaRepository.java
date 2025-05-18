package com.TechMantSPA.resenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMantSPA.resenas.model.Resenas;
@Repository
public interface ResenaRepository extends JpaRepository<Resenas, Long> {

}
