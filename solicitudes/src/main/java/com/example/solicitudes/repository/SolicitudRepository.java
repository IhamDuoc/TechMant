    package com.example.solicitudes.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import com.example.solicitudes.model.Solicitud;

    @Repository
    public interface SolicitudRepository extends JpaRepository<Solicitud,Long> {

    }
