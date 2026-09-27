package com.edu.ms_notificaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Analisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalisis;

    private Long idRecarga;
    private Long idTarjeta;
    private Double saldoDisponible;
    private Double montoRecarga;
    private LocalDateTime fechaRecarga;
    private String situacion; // "Aprobada" u "Observada"

    public Analisis() {
    }

    public Analisis(Long idRecarga, Long idTarjeta, Double saldoDisponible,
                     Double montoRecarga, LocalDateTime fechaRecarga, String situacion) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
        this.situacion = situacion;
    }

    public Long getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(Long idAnalisis) {
        this.idAnalisis = idAnalisis;
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

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
