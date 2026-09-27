package com.curso.front;

 HEAD
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.curso.front.config.RabbitMQConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
 0e87ccc15336a0aab705c93235319cb40681e889
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

 HEAD
import java.util.Map;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
 0e87ccc15336a0aab705c93235319cb40681e889

@RestController
public class RecargaController {

    private final RestTemplate restTemplate;
 HEAD

    public RecargaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    private final RabbitTemplate rabbitTemplate;

    public RecargaController(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
 0e87ccc15336a0aab705c93235319cb40681e889
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

 HEAD
        return Map.of(

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
 0e87ccc15336a0aab705c93235319cb40681e889
                "cuenta", cuentaId,
                "monto_solicitado", monto,
                "saldo_disponible", saldo,
                "recarga_aprobada", aprobada,
                "motivo", aprobada ? "Saldo suficiente" : "Saldo insuficiente",
 HEAD
                "atendido_por", respuestaCuenta.get("instancia")

                "mensaje_cola", "Enviado a " + RabbitMQConfig.QUEUE_NAME
 0e87ccc15336a0aab705c93235319cb40681e889
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
 HEAD
}

}
 0e87ccc15336a0aab705c93235319cb40681e889
