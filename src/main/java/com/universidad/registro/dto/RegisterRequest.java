package com.universidad.registro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String rol; // ADMIN, ESTUDIANTE, DOCENTE
}
