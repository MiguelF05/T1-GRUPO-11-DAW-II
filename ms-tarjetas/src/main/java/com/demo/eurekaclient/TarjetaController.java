package com.demo.eurekaclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {

    private final TarjetaRepository tarjetaRepository;

    @GetMapping
    public List<Tarjeta> listarTarjetas() {
        return tarjetaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarjeta obtenerTarjetaPorId(@PathVariable Long id) {
        return tarjetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
    }
}
