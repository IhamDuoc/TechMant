package com.example.tecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tecnico.model.Tecnico;
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Long>{

}
