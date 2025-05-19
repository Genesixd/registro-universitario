package com.universidad.registro.service.impl;

import com.universidad.registro.dto.EstudianteDTO;
import com.universidad.registro.model.Estudiante;
import com.universidad.registro.repository.EstudianteRepository;
import com.universidad.registro.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;

    private EstudianteDTO toDTO(Estudiante e) {
        return EstudianteDTO.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .apellido(e.getApellido())
                .numeroInscripcion(e.getNumeroInscripcion())
                .email(e.getEmail())
                .fechaNacimiento(e.getFechaNacimiento())
                .build();
    }

    private Estudiante toEntity(EstudianteDTO dto) {
        return Estudiante.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .numeroInscripcion(dto.getNumeroInscripcion())
                .email(dto.getEmail())
                .fechaNacimiento(dto.getFechaNacimiento())
                .build();
    }

    @CacheEvict(value = "estudiantes", allEntries = true)
    @Override
    public EstudianteDTO crear(EstudianteDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public EstudianteDTO obtenerPorId(Long id) {
        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return toDTO(estudiante);
    }

    @Cacheable("estudiantes")
    @Override
    public List<EstudianteDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @CacheEvict(value = "estudiantes", allEntries = true)
    @Override
    public EstudianteDTO actualizar(Long id, EstudianteDTO dto) {
        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setNumeroInscripcion(dto.getNumeroInscripcion());
        estudiante.setEmail(dto.getEmail());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        return toDTO(repository.save(estudiante));
    }

    @CacheEvict(value = "estudiantes", allEntries = true)
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
