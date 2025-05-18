package com.universidad.registro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la materia es obligatorio")
    private String nombreMateria;

    @NotBlank(message = "El código único es obligatorio")
    @Column(unique = true)
    private String codigoUnico;

    @Min(value = 1, message = "Debe tener al menos 1 crédito")
    private int creditos;

    private String docenteAsignado;
}
