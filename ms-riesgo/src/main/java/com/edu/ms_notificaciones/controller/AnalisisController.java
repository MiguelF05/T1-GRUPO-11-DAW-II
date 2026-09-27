package com.edu.ms_notificaciones.controller;

import com.edu.ms_notificaciones.model.Analisis;
import com.edu.ms_notificaciones.repository.AnalisisRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analisis")
public class AnalisisController {

    private final AnalisisRepository analisisRepository;

    public AnalisisController(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    // Lista el contenido de la tabla analisis
    @GetMapping
    public List<Analisis> listar() {
        return analisisRepository.findAll();
    }
}
