package com.demo.eurekaclient;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarjeta;

    private String nom_titular;
    private Double saldo_asignado;
    private Double saldo_disponible;
}