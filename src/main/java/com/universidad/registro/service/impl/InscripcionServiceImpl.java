package com.universidad.registro.service.impl;

import com.universidad.registro.dto.InscripcionDTO;
import com.universidad.registro.model.Estudiante;
import com.universidad.registro.model.Inscripcion;
import com.universidad.registro.model.Materia;
import com.universidad.registro.repository.EstudianteRepository;
import com.universidad.registro.repository.InscripcionRepository;
import com.universidad.registro.repository.MateriaRepository;
import com.universidad.registro.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionRepository repository;
    private final EstudianteRepository estudianteRepository;
    private final MateriaRepository materiaRepository;

    private InscripcionDTO toDTO(Inscripcion i) {
        return InscripcionDTO.builder()
                .id(i.getId())
                .estudianteId(i.getEstudiante().getId())
                .materiaId(i.getMateria().getId())
                .fechaInscripcion(i.getFechaInscripcion())
                .estado(i.getEstado())
                .build();
    }

    @Override
    public InscripcionDTO crear(InscripcionDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Inscripcion inscripcion = Inscripcion.builder()
                .estudiante(estudiante)
                .materia(materia)
                .fechaInscripcion(dto.getFechaInscripcion() != null ? dto.getFechaInscripcion() : LocalDate.now())
                .estado(dto.getEstado())
                .build();

        return toDTO(repository.save(inscripcion));
    }

    @Override
    public InscripcionDTO obtenerPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
    }

    @Override
    public List<InscripcionDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public InscripcionDTO actualizar(Long id, InscripcionDTO dto) {
        Inscripcion inscripcion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        inscripcion.setEstudiante(estudiante);
        inscripcion.setMateria(materia);
        inscripcion.setFechaInscripcion(dto.getFechaInscripcion());
        inscripcion.setEstado(dto.getEstado());

        return toDTO(repository.save(inscripcion));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
