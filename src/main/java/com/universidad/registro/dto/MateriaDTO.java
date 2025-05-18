package com.universidad.registro.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaDTO {

    private Long id;

    @NotBlank(message = "El nombre de la materia es obligatorio")
    private String nombreMateria;

    @NotBlank(message = "El código único es obligatorio")
    private String codigoUnico;

    @Min(value = 1, message = "Debe tener al menos 1 crédito")
    private int creditos;

    private String docenteAsignado;
}
