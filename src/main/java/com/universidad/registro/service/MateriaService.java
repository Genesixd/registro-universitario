package com.universidad.registro.service;

import com.universidad.registro.dto.MateriaDTO;

import java.util.List;

public interface MateriaService {
    MateriaDTO crear(MateriaDTO dto);
    MateriaDTO obtenerPorId(Long id);
    List<MateriaDTO> listar();
    MateriaDTO actualizar(Long id, MateriaDTO dto);
    void eliminar(Long id);
}
