package com.curso.front;

import com.curso.front.config.RabbitMQConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@RestController
public class RecargaController {

    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    public RecargaController(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/recargas/procesar/{cuentaId}/{monto}")
    @CircuitBreaker(name = "ms-cuentas", fallbackMethod = "fallbackRecarga")
    @SuppressWarnings("unchecked")
    public Map<String, Object> procesarRecarga(@PathVariable String cuentaId, @PathVariable double monto) {
        Map<String, Object> respuestaCuenta = restTemplate.getForObject(
                "http://ms-cuentas/cuentas/saldo/{cuentaId}",
                Map.class,
                cuentaId
        );

        double saldo = ((Number) respuestaCuenta.get("saldo")).doubleValue();
        boolean aprobada = saldo >= monto;

        // Generar un ID de recarga simulado
        Long idRecarga = new Random().nextLong(1000, 9999);
        String fechaActual = LocalDateTime.now().toString();

        // Si la recarga fue procesada correctamente, se envía el evento asíncrono a la cola
        RecargaEvento evento = new RecargaEvento(
                idRecarga,
                cuentaId,
                saldo,
                monto,
                fechaActual
        );

        // Publicar mensaje en RabbitMQ
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, evento);

        return Map.of(
                "id_recarga", idRecarga,
                "cuenta", cuentaId,
                "monto_solicitado", monto,
                "saldo_disponible", saldo,
                "recarga_aprobada", aprobada,
                "motivo", aprobada ? "Saldo suficiente" : "Saldo insuficiente",
                "mensaje_cola", "Enviado a " + RabbitMQConfig.QUEUE_NAME
        );
    }

    @SuppressWarnings("unused")
    public Map<String, Object> fallbackRecarga(String cuentaId, double monto, Exception e) {
        return Map.of(
                "cuenta", cuentaId,
                "monto_solicitado", monto,
                "recarga_aprobada", false,
                "motivo", "Servicio no disponible, intente mas tarde"
        );
    }
}