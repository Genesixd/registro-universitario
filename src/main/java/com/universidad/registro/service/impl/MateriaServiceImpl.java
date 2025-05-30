package com.universidad.registro.service.impl;

import com.universidad.registro.dto.MateriaDTO;
import com.universidad.registro.model.Materia;
import com.universidad.registro.repository.MateriaRepository;
import com.universidad.registro.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository repository;

    private MateriaDTO toDTO(Materia m) {
        return MateriaDTO.builder()
                .id(m.getId())
                .nombreMateria(m.getNombreMateria())
                .codigoUnico(m.getCodigoUnico())
                .creditos(m.getCreditos())
                .docenteAsignado(m.getDocenteAsignado())
                .build();
    }

    private Materia toEntity(MateriaDTO dto) {
        return Materia.builder()
                .nombreMateria(dto.getNombreMateria())
                .codigoUnico(dto.getCodigoUnico())
                .creditos(dto.getCreditos())
                .docenteAsignado(dto.getDocenteAsignado())
                .build();
    }

    @Override
    @CacheEvict(value = "materias", allEntries = true)
    public MateriaDTO crear(MateriaDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public MateriaDTO obtenerPorId(Long id) {
        Materia m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        return toDTO(m);
    }

    @Override
    @Cacheable(value = "materias")
    public List<MateriaDTO> listar() {
        System.out.println("🔥 Consultando base de datos de materias...");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = "materias", allEntries = true)
    public MateriaDTO actualizar(Long id, MateriaDTO dto) {
        Materia m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        m.setNombreMateria(dto.getNombreMateria());
        m.setCodigoUnico(dto.getCodigoUnico());
        m.setCreditos(dto.getCreditos());
        m.setDocenteAsignado(dto.getDocenteAsignado());

        return toDTO(repository.save(m));
    }

    @Override
    @CacheEvict(value = "materias", allEntries = true)
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
