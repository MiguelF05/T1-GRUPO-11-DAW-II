package com.curso.front;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RecargaEvento implements Serializable {
    private Long idRecarga;
    private String idTarjeta;
    private double saldoDisponible;
    private double montoRecarga;
    private String fechaRecarga;

    public RecargaEvento() {}

    public RecargaEvento(Long idRecarga, String idTarjeta, double saldoDisponible, double montoRecarga, String fechaRecarga) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
    }

    // Getters y Setters
    public Long getIdRecarga() { return idRecarga; }
    public void setIdRecarga(Long idRecarga) { this.idRecarga = idRecarga; }

    public String getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(String idTarjeta) { this.idTarjeta = idTarjeta; }

    public double getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(double saldoDisponible) { this.saldoDisponible = saldoDisponible; }

    public double getMontoRecarga() { return montoRecarga; }
    public void setMontoRecarga(double montoRecarga) { this.montoRecarga = montoRecarga; }

    public String getFechaRecarga() { return fechaRecarga; }
    public void setFechaRecarga(String fechaRecarga) { this.fechaRecarga = fechaRecarga; }
}