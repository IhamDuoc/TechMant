package com.TechMant.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechMant.categoria.model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
