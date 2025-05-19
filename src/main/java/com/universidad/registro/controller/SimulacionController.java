// src/main/java/com/universidad/registro/controller/SimulacionController.java

package com.universidad.registro.controller;

import com.universidad.registro.service.TareaConcurrenteService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulacion")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class SimulacionController {

    private final TareaConcurrenteService servicio;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/async")
    
    public ResponseEntity<String> simularTareas() {
        for (int i = 1; i <= 5; i++) {
            servicio.ejecutarTareaLenta("Tarea-" + i);
        }
        return ResponseEntity.ok("✅ Tareas lanzadas en paralelo.");
    }
}
