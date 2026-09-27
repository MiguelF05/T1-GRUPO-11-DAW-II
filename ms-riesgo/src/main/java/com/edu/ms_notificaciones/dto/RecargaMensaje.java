package com.edu.ms_notificaciones.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RecargaMensaje implements Serializable {

    private Long idRecarga;
    private Long idTarjeta;
    private Double saldoDisponible;
    private Double montoRecarga;
    private LocalDateTime fechaRecarga;

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
