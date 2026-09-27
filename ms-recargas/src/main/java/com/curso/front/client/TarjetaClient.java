package com.curso.front.client;

import com.curso.front.dto.TarjetaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "ms-tarjetas" es el spring.application.name registrado en Eureka;
// no se necesita URL fija porque el LoadBalancer lo resuelve.
@FeignClient(name = "ms-tarjetas")
public interface TarjetaClient {

    @GetMapping("/tarjetas/{id}")
    TarjetaDTO consultarPorId(@PathVariable("id") Long id);
}
