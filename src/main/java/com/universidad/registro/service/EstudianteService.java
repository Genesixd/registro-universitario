package com.universidad.registro.service;

import com.universidad.registro.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO crear(EstudianteDTO dto);
    EstudianteDTO obtenerPorId(Long id);
    List<EstudianteDTO> listar();
    EstudianteDTO actualizar(Long id, EstudianteDTO dto);
    void eliminar(Long id);
}
