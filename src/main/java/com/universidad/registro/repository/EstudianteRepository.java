package com.universidad.registro.repository;

import com.universidad.registro.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByNumeroInscripcion(String numeroInscripcion);
    boolean existsByEmail(String email);
}
