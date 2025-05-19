package com.universidad.registro.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TareaConcurrenteService {

    @Async
    public void ejecutarTareaLenta(String nombre) {
        try {
            log.info("▶️ Iniciando tarea: " + nombre + " en hilo " + Thread.currentThread().getName());
            Thread.sleep(5000);
            log.info("✅ Tarea finalizada: " + nombre);
        } catch (InterruptedException e) {
            log.error("❌ Error en tarea: " + nombre);
        }
    }
}
