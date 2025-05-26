package com.TechMant.privilegios.repository;

import com.TechMant.privilegios.model.Privilegios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegiosRepository extends JpaRepository<Privilegios, Long> {
}