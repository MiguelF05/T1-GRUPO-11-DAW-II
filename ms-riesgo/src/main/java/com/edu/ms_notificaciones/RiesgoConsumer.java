package com.edu.ms_notificaciones;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RiesgoConsumer {

    private final AnalisisRepository analisisRepository;

    public RiesgoConsumer(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    //Mi apellido es Peña pero lo coloco así para no causar conflictos
    @RabbitListener(queues = "Penia_Queue")
    public void recibirYAnalizarSolicitud(RecargaEvento evento) {

        double limite70 = evento.getSaldoDisponible() * 0.70;
        String situacion = (evento.getMontoRecarga() <= limite70) ? "Aprobada" : "Observada";

        Analisis registro = new Analisis(
                evento.getIdRecarga(),
                evento.getIdTarjeta(),
                evento.getSaldoDisponible(),
                evento.getMontoRecarga(),
                evento.getFechaRecarga(),
                situacion
        );

        analisisRepository.save(registro);
        System.out.println("Analisis guardado exitosamente. Estado: " + situacion);
    }
}