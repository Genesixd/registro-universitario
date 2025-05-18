package com.universidad.registro.repository;

import com.universidad.registro.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
