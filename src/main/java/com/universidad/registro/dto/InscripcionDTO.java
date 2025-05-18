package com.universidad.registro.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionDTO {

    private Long id;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Long estudianteId;

    @NotNull(message = "El ID de la materia es obligatorio")
    private Long materiaId;

    private LocalDate fechaInscripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;
}
