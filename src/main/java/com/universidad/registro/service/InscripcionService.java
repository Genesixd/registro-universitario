package com.universidad.registro.service;

import com.universidad.registro.dto.InscripcionDTO;

import java.util.List;

public interface InscripcionService {
    InscripcionDTO crear(InscripcionDTO dto);
    InscripcionDTO obtenerPorId(Long id);
    List<InscripcionDTO> listar();
    InscripcionDTO actualizar(Long id, InscripcionDTO dto);
    void eliminar(Long id);
}
