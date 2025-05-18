package com.universidad.registro.controller;

import com.universidad.registro.dto.InscripcionDTO;
import com.universidad.registro.service.InscripcionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService service;

    @PostMapping
    public ResponseEntity<InscripcionDTO> crear(@Valid @RequestBody InscripcionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionDTO> actualizar(@PathVariable Long id, @Valid @RequestBody InscripcionDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
