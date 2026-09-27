package com.curso.front.service;

import com.curso.front.client.TarjetaClient;
import com.curso.front.dto.RecargaMensaje;
import com.curso.front.dto.RecargaRequest;
import com.curso.front.dto.TarjetaDTO;
import com.curso.front.model.Recarga;
import com.curso.front.repository.RecargaRepository;
import feign.FeignException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecargaService {

    private final TarjetaClient tarjetaClient;
    private final RecargaRepository recargaRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("${mensajeria.cola}")
    private String nombreCola;

    public RecargaService(TarjetaClient tarjetaClient,
                           RecargaRepository recargaRepository,
                           RabbitTemplate rabbitTemplate) {
        this.tarjetaClient = tarjetaClient;
        this.recargaRepository = recargaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Recarga registrarRecarga(RecargaRequest request) {

        TarjetaDTO tarjeta;
        try {
            tarjeta = tarjetaClient.consultarPorId(request.getIdTarjeta());
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException(
                    "La tarjeta " + request.getIdTarjeta() + " no existe");
        }

        Recarga recarga = new Recarga(
                request.getIdTarjeta(),
                tarjeta.getSaldo_disponible(),
                request.getMontoRecarga(),
                LocalDateTime.now() // fecha_recarga automatica
        );
        recarga = recargaRepository.save(recarga);

        RecargaMensaje mensaje = new RecargaMensaje(
                recarga.getIdRecarga(),
                recarga.getIdTarjeta(),
                recarga.getSaldoDisponible(),
                recarga.getMontoRecarga(),
                recarga.getFechaRecarga()
        );
        rabbitTemplate.convertAndSend(nombreCola, mensaje);

        return recarga;
    }
}
