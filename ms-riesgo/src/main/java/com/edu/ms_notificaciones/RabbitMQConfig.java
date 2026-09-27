package com.edu.ms_notificaciones;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "Serrano_Queue";

    @Bean
    public Queue serranoQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}