package com.example.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usuario.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol,Long> {

}
