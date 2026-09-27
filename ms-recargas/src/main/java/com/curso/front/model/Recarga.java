package com.curso.front.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Recarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecarga;

    private Long idTarjeta;

    private Double saldoDisponible;

    private Double montoRecarga;

    private LocalDateTime fechaRecarga;

    public Recarga() {
    }

    public Recarga(Long idTarjeta, Double saldoDisponible, Double montoRecarga, LocalDateTime fechaRecarga) {
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
    }

    public Long getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(Long idRecarga) {
        this.idRecarga = idRecarga;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Double getMontoRecarga() {
        return montoRecarga;
    }

    public void setMontoRecarga(Double montoRecarga) {
        this.montoRecarga = montoRecarga;
    }

    public LocalDateTime getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(LocalDateTime fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }
}
