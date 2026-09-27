package com.curso.front;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tarjetas")
public interface TarjetaClient {

    @GetMapping("/tarjetas/{id}")
    Object obtenerTarjetaPorId(@PathVariable("id") Long id);
}
