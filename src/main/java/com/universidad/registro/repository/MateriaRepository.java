package com.universidad.registro.repository;

import com.universidad.registro.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
    boolean existsByCodigoUnico(String codigoUnico);
    Optional<Materia> findByCodigoUnico(String codigoUnico);
}
