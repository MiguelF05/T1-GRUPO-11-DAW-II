package com.edu.ms_notificaciones.listener;

import com.edu.ms_notificaciones.RabbitMQConfig;
import com.edu.ms_notificaciones.dto.RecargaMensaje;
import com.edu.ms_notificaciones.model.Analisis;
import com.edu.ms_notificaciones.repository.AnalisisRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecargaListener {

    private final AnalisisRepository analisisRepository;

    @Value("${riesgo.umbral}")
    private double umbral; // 0.7 -> 70%

    public RecargaListener(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void recibirRecarga(RecargaMensaje mensaje) {

        double limite = mensaje.getSaldoDisponible() * umbral;
        String situacion = (mensaje.getMontoRecarga() <= limite) ? "Aprobada" : "Observada";

        Analisis analisis = new Analisis(
                mensaje.getIdRecarga(),
                mensaje.getIdTarjeta(),
                mensaje.getSaldoDisponible(),
                mensaje.getMontoRecarga(),
                mensaje.getFechaRecarga(),
                situacion
        );

        analisisRepository.save(analisis);
    }
}
